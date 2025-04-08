import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { Observable } from 'rxjs';
import { Test } from 'src/app/classes/test';
import { TestsService } from 'src/app/services/tests.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-tests-list',
  templateUrl: './tests-list.component.html',
  styleUrls: ['./tests-list.component.scss']
})
export class TestsListComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['name'];
  dataSource: MatTableDataSource<Test> = new MatTableDataSource<Test>();
  loading: boolean = true;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private testsService: TestsService) { }

  ngOnInit(): void {
    this.loading = true;
    this.refresh();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  refresh() {
    // We call the service and display the returned list of tests.
    this.testsService.getAll().subscribe(tests => {
      this.dataSource = new MatTableDataSource(tests);
      this.loading = false;
    });
  }
}
