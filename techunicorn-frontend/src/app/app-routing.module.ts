import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {DefaultComponent} from 'src/app/components/default/default.component';
import {CreateCandidateComponent} from 'src/app/components/create-candidate/create-candidate.component';
import {CandidatesListComponent} from 'src/app/components/candidates-list/candidates-list.component';
import {TestsListComponent} from 'src/app/components/tests-list/tests-list.component';

const routes: Routes = [
  { path: 'candidates', component: CandidatesListComponent},
  { path: 'tests', component: TestsListComponent},
  { path: '', component: DefaultComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
