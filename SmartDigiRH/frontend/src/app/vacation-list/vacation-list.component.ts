import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vacation } from '../models/vacation-interface/vacation';
import { VacationService } from '../vacation-service/vacation.service';

@Component({
  selector: 'app-vacation-list',
  templateUrl: './vacation-list.component.html',
  styleUrls: ['./vacation-list.component.css']
})
export class VacationListComponent implements OnInit {

pageSize = 0;
perPage = 4;
p: number = 1;
type = '';
vacationId = '';

  vacations: Vacation [] = [];
  
    constructor(private vacationService: VacationService, private router:Router) { }
  
    ngOnInit(): void {
  
      this.getVactions();
    }
  
    private getVactions(){
      this.vacationService.getVacationList().subscribe(data =>{
        this.vacations = data;
      });
    }
  
    vacationDetails(vacationId:number){
      this.router.navigate(['vacation-details', vacationId]);
  
    }
  
    updateVacation(vacationId: number){
      this.router.navigate(['update-vacation', vacationId]);
    }
    deleteVacation (vacationId: number){
      this.vacationService.deleteVacation(vacationId).subscribe(data =>{
     console.log(data);
        this.getVactions();
      })
    }
  
    getData(){
      /*this.httpclient.get<UserInterface>("http://localhost:8080/auth/users")*/
    }
  
  }
  