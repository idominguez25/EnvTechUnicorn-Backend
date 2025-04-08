import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Candidate } from 'src/app/classes/candidate';
import { CandidatesService } from 'src/app/services/candidates.service';


@Component({
  selector: 'app-modal-delete',
  templateUrl: './modal-delete.component.html',
  styleUrls: ['./modal-delete.component.scss']
})
export class ModalDeleteComponent implements OnInit {

  status : number = 0;

  constructor(public modal: MatDialogRef<ModalDeleteComponent>, @Inject(MAT_DIALOG_DATA) public data: Candidate[], private candidatesService: CandidatesService) {}

  ngOnInit(): void {
  }
    confirm(){
      this.status = 1
      var id = (this.data.map(function extractId(candidate: Candidate) { return candidate.id}));
      this.candidatesService.deleteCandidate(id).subscribe(
        (res) => {
          while (res.status !== 200) {
            this.status = 1;
          }
            this.status = 2
    }
      )
  }
}
