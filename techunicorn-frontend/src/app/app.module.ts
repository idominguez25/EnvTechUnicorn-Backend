import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";

// Angular FormsModule.
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

// Material Design components.
import {MatToolbarModule} from '@angular/material/toolbar'; 
import {MatDividerModule} from '@angular/material/divider';
import {MatProgressBarModule} from '@angular/material/progress-bar'; 
import {MatIconModule} from '@angular/material/icon'; 
import {MatButtonModule} from '@angular/material/button'; 
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator'; 
import {MatSortModule} from '@angular/material/sort';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatDialogModule} from '@angular/material/dialog';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DefaultComponent } from './components/default/default.component';
import { CandidatesListComponent, ModalInvite } from './components/candidates-list/candidates-list.component';
import { CandidatesService } from './services/candidates.service';
import { CandidateComponent } from './components/candidate/candidate.component';
import { InviteCandidateComponent } from './components/invite-candidate/invite-candidate.component';
import { CreateCandidateComponent } from './components/create-candidate/create-candidate.component';
import { TestsListComponent } from './components/tests-list/tests-list.component';
import { TestsService } from './services/tests.service';
import { ModalDeleteComponent } from './components/modal-delete/modal-delete.component';
import { StatusPipe } from './pipes/status.pipe';


@NgModule({
  declarations: [
    AppComponent,
    DefaultComponent,
    CandidatesListComponent,
    CandidateComponent,
    InviteCandidateComponent,
    CreateCandidateComponent,
    TestsListComponent,
    ModalInvite,
    ModalDeleteComponent,
    StatusPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatDividerModule,
    MatProgressBarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatGridListModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatInputModule,
    MatSelectModule,
    MatDialogModule,
    MatCheckboxModule,
    MatButtonToggleModule,
    MatSnackBarModule,
    MatProgressSpinnerModule
  ],
  providers: [CandidatesService, TestsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
