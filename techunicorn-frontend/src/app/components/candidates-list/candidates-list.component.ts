import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { Candidate } from 'src/app/classes/candidate';
import { CandidatesService } from 'src/app/services/candidates.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog} from '@angular/material/dialog';
import {SelectionModel} from '@angular/cdk/collections';
import { ModalDeleteComponent } from '../modal-delete/modal-delete.component';

@Component({
  selector: 'app-candidates-list',
  templateUrl: './candidates-list.component.html',
  styleUrls: ['./candidates-list.component.scss']
})
export class CandidatesListComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['select', 'email', 'firstName', 'lastName', 'percentage'];
  dataSource: MatTableDataSource<Candidate> = new MatTableDataSource<Candidate>();
  selection = new SelectionModel<Candidate>(true, []);
  loading: boolean = true;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  constructor(public modal: MatDialog, private candidatesService: CandidatesService) { }

  ngOnInit(): void {
    this.loading = true;
    this.refresh();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  refresh() {
    // We call the service and save the list of candidates that the observable returns.
    this.candidatesService.getAll().subscribe(candidates => {
      this.dataSource.data = candidates;
      this.dataSource.paginator = this.paginator;
      this.loading = false;
    });
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }
    this.selection.select(...this.dataSource.data);
  }

  openModal(){
    const dialogRef = this.modal.open(ModalInvite);

    dialogRef.afterClosed().subscribe(result => {
      this.refresh();
    });
  }

  delete(): void{
    const dialogRef = this.modal.open(ModalDeleteComponent, {data: this.selection.selected});
   
    dialogRef.afterClosed().subscribe(result => {
      this.selection.clear();
      this.refresh();
    });
  }
 
}

@Component({
  selector: 'modal-invite',
  templateUrl: 'modal-invite.html'
})
export class ModalInvite {}