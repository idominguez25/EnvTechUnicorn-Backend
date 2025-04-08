import { Injectable } from '@angular/core';
import { Candidate } from '../classes/candidate';
import { HttpClient } from "@angular/common/http";
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Skill } from '../classes/skill';
import {MatSnackBar} from '@angular/material/snack-bar';
import { environment } from '../../environments/environment';
import { CandidateTest } from '../classes/candidate-test';

@Injectable({
  providedIn: 'root'
})
export class CandidatesService {

  constructor(private http: HttpClient, private snackBar: MatSnackBar) {}

  // Returns the list of candidates.
  getAll(): Observable<Candidate[]> {
    return this.http.get<Candidate[]>(environment.BACKEND_BASE_URL + '/candidates').pipe(
      catchError(this.handleError<Candidate[]>('An error has occurred.', []))
    );
  }

  addCandidate(newCandidate : Candidate): Observable<Candidate> {
      return this.http.post<Candidate>(environment.BACKEND_BASE_URL + '/candidates', newCandidate).pipe(
        catchError(this.handleError('An error has occurred.', newCandidate)));
    }
  
  inviteCandidate(candidateTest: CandidateTest){
    return this.http.post<CandidateTest>(environment.BACKEND_BASE_URL + '/candidates/invite-by-skill', candidateTest, {observe: 'response'});
    //.pipe(catchError(this.handleError('An error has occurred.')));
  }

  listSkills(): Observable<Skill[]>{
    return this.http.get<Skill[]>(environment.BACKEND_BASE_URL + '/skills').pipe(
      catchError(this.handleError<Skill[]>('An error has occurred.', [])));

  }

  deleteCandidate(candidatesIds: number[]) {
    return this.http.delete(environment.BACKEND_BASE_URL + '/candidates', {body: candidatesIds, observe: 'response' });
    //.pipe(catchError(this.handleError('deleteCandidate')));
  
}

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.log(`${operation} ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  private log(message: string) {
    this.snackBar.open(message, 'Dismiss');
  }

}
