import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { environment } from 'src/environments/environment';
import { UserInterface } from '../models/user-interface';
import { User } from '../User/user';
@Injectable({providedIn: 'root'})
export class UserService {
  
//private baseURL = environment.baseURL;

  private baseURL = "http://localhost:8080/user";
  constructor(private httpClient: HttpClient) { }

getUsersList():Observable<UserInterface[]>{

  return this.httpClient.get<UserInterface[]>(`${this.baseURL}`);
}

createUser(user:User): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, user);
}

getUserById(id: number): Observable<UserInterface>{
  return this.httpClient.get<UserInterface>(`${this.baseURL}/${id}`);
}

updateUser(id:number, user: User): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${id}`,user);
}

deleteUser(id: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${id}`);

}
}
