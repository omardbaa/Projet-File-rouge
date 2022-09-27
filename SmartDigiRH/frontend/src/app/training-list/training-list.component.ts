import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Training } from '../models/training-interface/training';
import { TrainingService } from '../training-service/training.service';

@Component({
  selector: 'app-training-list',
  templateUrl: './training-list.component.html',
  styleUrls: ['./training-list.component.css']
})
export class TrainingListComponent implements OnInit {

pageSize = 0;
perPage = 4;
p: number = 1;
title = '';
trainingId = '';
training_Id!:number;


  allEmployees: any = [];
  trainings: Training[] = [];

  constructor(private trainingService : TrainingService, private router: Router) { }

  ngOnInit(): void {

    this.getTrainings();

  }

  private getTrainings(){
    this.trainingService.getTrainingList().subscribe(data =>{
      this.trainings = data;
    });
  }

 trainingDetails(trainingId:number){
    this.router.navigate(['admin/training-details', trainingId]);

  }

  updateTraining(trainingId: number){
    this.router.navigate(['admin/update-training', trainingId]);
  }
  deleteTraining (trainingId: number){
    this.trainingService.deleteTraining(trainingId).subscribe(data =>{
   console.log(data);
      this.getTrainings();
    })
  }

  getData(){
    /*this.httpclient.get<UserInterface>("http://localhost:8080/auth/users")*/
  }




}

