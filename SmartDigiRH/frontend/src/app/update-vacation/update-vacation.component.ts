import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Vacation } from '../models/vacation-interface/vacation';
import { VacationService } from '../vacation-service/vacation.service';

@Component({
  selector: 'app-update-vacation',
  templateUrl: './update-vacation.component.html',
  styleUrls: ['./update-vacation.component.css']
})
export class UpdateVacationComponent implements OnInit {


  vacationId!: number;
  vacation: Vacation = new Vacation();
  constructor(private vacationService: VacationService, 
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.vacationId = this.route.snapshot.params['id'];
    this.vacationService.getVacationById(this.vacationId).subscribe(data =>{
      this.vacation = data;
    },error => console.log(error));
    
    }
   
    onSubmit(){
      this.vacationService.updateVacation(this.vacationId, this.vacation).subscribe(data =>{
        this.goToVacationList();
      },
         error => console.log(error));
     
  
    }

    goToVacationList(){
      this.router.navigate(['admin/vacations']);
  
    }
  }
