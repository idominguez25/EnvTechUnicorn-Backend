import { Component, OnInit } from '@angular/core';
import { CandidatesService } from 'src/app/services/candidates.service';
import { Candidate } from 'src/app/classes/candidate';

@Component({
  selector: 'app-create-candidate',
  templateUrl: './create-candidate.component.html',
  styleUrls: ['./create-candidate.component.scss']
})
export class CreateCandidateComponent implements OnInit {

  newCandidate: Candidate = new Candidate(-1, "", "", "", []);

  constructor(private candidatesService: CandidatesService) { }

  ngOnInit(): void {
  }

  create() {
    this.candidatesService.addCandidate(this.newCandidate).subscribe();
    this.candidatesService.getAll();
  }
}
