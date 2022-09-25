import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../models/project-interface/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectServiceService {


  private baseURL = "http://localhost:8080/project";
  constructor(private httpClient: HttpClient) { }

getProjectList():Observable<Project[]>{

  return this.httpClient.get<Project[]>(`${this.baseURL}`);
}

createProject(projct:Project): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, projct);
}

getProjectById(projectId: number): Observable<Project>{
  return this.httpClient.get<Project>(`${this.baseURL}/${projectId}`);
}

updateProject(projectId:number, project: Project): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${projectId}`,project);
}

deleteProject(projectId: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${projectId}`);

}


//	Get All Projects
//	@PostAuthorize("hasAuthority('ADMIN')")
// @CrossOrigin(origins = "http://localhost:4200")
// @GetMapping
// public ResponseEntity<List<Project>> getAll() {
//   List<Project> projects = service.getAll();
//   return new ResponseEntity<>(projects, HttpStatus.OK);

// }

// // getAllEmployeeOfProject

// @GetMapping("all/{id}")
// public List<Employee> getAllEmployeeOfProject(@PathVariable("id") Long projectId) {

//   return this.employeeServiceImpl.getAllEmployeeOfProject(projectId);





getAllEmployees(projectId: number): Observable<Project>{
  return this.httpClient.get<Project>(`${this.baseURL}/${projectId}`+'/employees');
}


}
