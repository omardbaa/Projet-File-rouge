import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../models/employee';
import { Vacation } from '../models/vacation-interface/vacation';
import { VacationService } from '../vacation-service/vacation.service';

@Component({
  selector: 'app-vacation-details',
  templateUrl: './vacation-details.component.html',
  styleUrls: ['./vacation-details.component.css']
})
export class VacationDetailsComponent implements OnInit {


  


  allEmployees: any = [];
  
 vacationId!: number;
  vacation: Vacation = new Vacation;
  
  employee: Employee= new Employee;
  
  userId!:number;
  
  
  
    constructor(private vacationService: VacationService , private route: ActivatedRoute) { }
  
    
  
    ngOnInit(): void {
      this.vacationId = this.route.snapshot.params['id'];
      this.vacation = new Vacation();
      this.vacationService.getVacationById(this.vacationId).subscribe(data => {
        this.vacation = data;
  
        this.getEmployees();
      });
  
  
  
    }
  
  
    private getEmployees(){
      this.vacationService.getAllEmployees(this.vacationId).subscribe(data =>{
        this.allEmployees = data;
      });
    }
    
  
  }
  
