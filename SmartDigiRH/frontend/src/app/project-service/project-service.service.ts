import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProjectInterface } from '../models/project-interface/project-interface';

@Injectable({
  providedIn: 'root'
})
export class ProjectServiceService {


  private baseURL = "http://localhost:8080/project";
  constructor(private httpClient: HttpClient) { }

getProjectList():Observable<ProjectInterface[]>{

  return this.httpClient.get<ProjectInterface[]>(`${this.baseURL}`);
}

createProject(projct:ProjectInterface): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, projct);
}

getProjectById(projectId: number): Observable<ProjectInterface>{
  return this.httpClient.get<ProjectInterface>(`${this.baseURL}/${projectId}`);
}

updateProject(projectId:number, project: ProjectInterface): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${projectId}`,project);
}

deleteProject(projectId: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${projectId}`);

}
}
