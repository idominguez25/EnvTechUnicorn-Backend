import { Component, OnInit, Input } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { Candidate } from 'src/app/classes/candidate';

@Component({
  selector: 'app-candidate',
  templateUrl: './candidate.component.html',
  styleUrls: ['./candidate.component.scss']
})
export class CandidateComponent implements OnInit {
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  @Input() candidate: Candidate = new Candidate(-1, "", "", "", []);
  
  constructor() {
  }

  ngOnInit(): void {
  }

 
   

}