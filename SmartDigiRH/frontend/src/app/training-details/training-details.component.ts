import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../models/employee';
import { Training } from '../models/training-interface/training';
import { TrainingService } from '../training-service/training.service';

@Component({
  selector: 'app-training-details',
  templateUrl: './training-details.component.html',
  styleUrls: ['./training-details.component.css']
})
export class TrainingDetailsComponent implements OnInit {

  


  allEmployees: any = [];
  
  trainingId!: number;
  training: Training = new Training;
  
  employee: Employee= new Employee;
  
  userId!:number;
  
  
  
    constructor(private trainingService: TrainingService , private route: ActivatedRoute) { }
  
    
  
    ngOnInit(): void {
      this.trainingId = this.route.snapshot.params['id'];
      this.training = new Training();
      this.trainingService.getTrainingById(this.trainingId).subscribe(data => {
        this.training = data;
  
        this.getEmployees();
      });
  
  
  
    }
  
  
    private getEmployees(){
      this.trainingService.getAllEmployees(this.trainingId).subscribe(data =>{
        this.allEmployees = data;
      });
    }
    
  
  }
  