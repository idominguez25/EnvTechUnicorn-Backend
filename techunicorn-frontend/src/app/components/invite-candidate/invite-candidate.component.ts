import { Component, OnInit } from '@angular/core';
import { Candidate } from 'src/app/classes/candidate';
import { CandidateTest } from 'src/app/classes/candidate-test';
import { Skill } from 'src/app/classes/skill';
import { Test } from 'src/app/classes/test';
import { CandidatesService } from 'src/app/services/candidates.service';

@Component({
  selector: 'app-invite-candidate',
  templateUrl: './invite-candidate.component.html',
  styleUrls: ['./invite-candidate.component.scss']
})
export class InviteCandidateComponent implements OnInit {
  newCandidate: Candidate = new Candidate(-1, "", "", "", []);
  selectedSkill: string = "";
  skills: Skill[] = [];
  skill: Skill;
  test: Test;
  candidateTest: CandidateTest;
  status : number = 0;

  constructor(private candidatesService: CandidatesService) { }

  ngOnInit(): void {
    this.getSkills();
  }

  getSkills(){
    this.candidatesService.listSkills().subscribe(retorno => this.skills = retorno);
  }

  invite() {
    this.status = 1
    this.skill = new Skill (this.selectedSkill);
    this.test = new Test('', [this.skill]);
    this.candidateTest = new CandidateTest(this.newCandidate, this.test);

    //this.candidatesService.addCandidate(this.newCandidate).subscribe(candidate => {console.log(candidate)});
    this.candidatesService.inviteCandidate(this.candidateTest).subscribe((res) => {
      while (res.status !== 200) {
        this.status = 1;
      }
        this.status = 2
});
  }
}
