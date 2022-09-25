import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Training } from '../models/training-interface/training';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {



  private baseURL = "http://localhost:8080/training";
  constructor(private httpClient: HttpClient) { }

getTrainingList():Observable<Training[]>{

  return this.httpClient.get<Training[]>(`${this.baseURL}`);
}

createTraining(training:Training): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, training);
}

getTrainingById(trainingId: number): Observable<Training>{
  return this.httpClient.get<Training>(`${this.baseURL}/${trainingId}`);
}

updateTraining(trainingId:number, training: Training): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${trainingId}`,training);
}

deleteTraining(trainingId: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${trainingId}`);

}



getAllEmployees(trainingId: number): Observable<Training>{
  return this.httpClient.get<Training>(`${this.baseURL}/${trainingId}`+'/employees');
}


}