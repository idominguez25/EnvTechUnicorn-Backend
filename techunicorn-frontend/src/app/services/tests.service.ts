import { Injectable } from '@angular/core';
import { Test } from '../classes/test';
import { HttpClient } from "@angular/common/http";
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

import {MatSnackBar} from '@angular/material/snack-bar';

import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TestsService {

  constructor(private http: HttpClient, private snackBar: MatSnackBar) {}

  // Returns the list of available tests.
  getAll(): Observable<Test[]> {
    return this.http.get<Test[]>(environment.BACKEND_BASE_URL +  '/tests').pipe(
      tap(_ => null),
      catchError(this.handleError<Test[]>('An error has occurred.', []))
    );
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
