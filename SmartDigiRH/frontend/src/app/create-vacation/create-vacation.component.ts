import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vacation } from '../models/vacation-interface/vacation';
import { VacationService } from '../vacation-service/vacation.service';

@Component({
  selector: 'app-create-vacation',
  templateUrl: './create-vacation.component.html',
  styleUrls: ['./create-vacation.component.css']
})
export class CreateVacationComponent implements OnInit {

  vacation: Vacation = new Vacation();
  constructor(private vacationService: VacationService, 
    private router: Router) { }

  ngOnInit(): void {
  }

  saveVacation(){
this.vacationService.createVacation(this.vacation).subscribe(data => {
  console.log(data);
  this.goToVacationList();

},
  error => console.log(error));
}

goToVacationList(){
    this.router.navigate(['admin/vacations']);

  }

  onSubmit(){
    console.log(this.vacation);
    this.saveVacation()
    this.goToVacationList();

  }

}

