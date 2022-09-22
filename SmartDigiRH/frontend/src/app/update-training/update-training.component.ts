import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Training } from '../models/training-interface/training';
import { TrainingService } from '../training-service/training.service';

@Component({
  selector: 'app-update-training',
  templateUrl: './update-training.component.html',
  styleUrls: ['./update-training.component.css']
})
export class UpdateTrainingComponent implements OnInit {



  trainingId!: number;
  training: Training = new Training();
  constructor(private trainingService: TrainingService, 
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.trainingId = this.route.snapshot.params['id'];
    this.trainingService.getTrainingById(this.trainingId).subscribe(data =>{
      this.training = data;
    },error => console.log(error));
    
    }
   
    onSubmit(){
      this.trainingService.updateTraining(this.trainingId, this.training).subscribe(data =>{
        this.goToTrainingList();
      },
         error => console.log(error));
     
  
    }

    goToTrainingList(){
      this.router.navigate(['/trainings']);
  
    }
  }