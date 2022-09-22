import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
@Injectable({providedIn: 'root'})
export class UserService {
  
//private baseURL = environment.baseURL;

  private baseURL = "http://localhost:8080/user/employee";
  constructor(private httpClient: HttpClient) { }

getUsersList():Observable<User[]>{

  return this.httpClient.get<User[]>(`${this.baseURL}`);
}

createUser(user:User): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, user);
}

getUserById(userId: number): Observable<User>{
  return this.httpClient.get<User>(`${this.baseURL}/${userId}`);
}

updateUser(userId:number, user: User): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${userId}`,user);
}

deleteUser(userId: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${userId}`);

}
}
