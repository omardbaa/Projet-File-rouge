import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Training } from '../models/training-interface/training';
import { TrainingService } from '../training-service/training.service';

@Component({
  selector: 'app-create-training',
  templateUrl: './create-training.component.html',
  styleUrls: ['./create-training.component.css']
})
export class CreateTrainingComponent implements OnInit {


  training: Training = new Training();
  constructor(private trainingService: TrainingService, 
    private router: Router) { }

  ngOnInit(): void {
  }

  saveTraining(){
this.trainingService.createTraining(this.training).subscribe(data => {
  console.log(data);
  this.goToTrainingList();

},
  error => console.log(error));
}

goToTrainingList(){
    this.router.navigate(['/trainings']);

  }

  onSubmit(){
    console.log(this.training);
    this.saveTraining()
    this.goToTrainingList();

  }

}
