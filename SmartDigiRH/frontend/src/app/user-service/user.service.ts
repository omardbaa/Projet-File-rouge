import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { environment } from 'src/environments/environment';
import { Employee } from '../models/employee';
@Injectable({providedIn: 'root'})
export class UserService {
  
//private baseURL = environment.baseURL;

  private baseURL = "http://localhost:8080/user/employee";
  constructor(private httpClient: HttpClient) { }

getUsersList():Observable<Employee[]>{

  return this.httpClient.get<Employee[]>(`${this.baseURL}`);
}

createUser(user:Employee): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, user);
}

getUserById(userId: number): Observable<Employee>{
  return this.httpClient.get<Employee>(`${this.baseURL}/${userId}`);
}

updateUser(userId:number, user: Employee): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${userId}`,user);
}

deleteUser(userId: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${userId}`);

}
}
