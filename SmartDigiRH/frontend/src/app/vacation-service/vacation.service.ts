import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vacation } from '../models/vacation-interface/vacation';

@Injectable({
  providedIn: 'root'
})
export class VacationService {


  private baseURL = "http://localhost:8080/vacation";
  constructor(private httpClient: HttpClient) { }

getVacationList():Observable<Vacation[]>{

  return this.httpClient.get<Vacation[]>(`${this.baseURL}`);
}

createVacation(vacation:Vacation): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, vacation);
}

getVacationById(vacationId: number): Observable<Vacation>{
  return this.httpClient.get<Vacation>(`${this.baseURL}/${vacationId}`);
}

updateVacation(vacationId:number, vacation: Vacation): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${vacationId}`,vacation);
}

deleteVacation(vacationId: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${vacationId}`);

}


getAllEmployees(vacationId: number): Observable<Vacation>{
  return this.httpClient.get<Vacation>(`${this.baseURL}/${vacationId}`+'/employees');
}

}