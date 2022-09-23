import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Project } from "../models/project-interface/project";
import { ProjectServiceService } from "../project-service/project-service.service";

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {

    pageSize = 0;
  perPage = 4;
  p: number = 1;
  title = '';
  projectId = '';

projects: Project [] = [];

  constructor(private projectservice: ProjectServiceService, private router:Router) { }

  ngOnInit(): void {

    this.getProjects();
  }

  private getProjects(){
    this.projectservice.getProjectList().subscribe(data =>{
      this.projects = data;
    });
  }

  projectDetails(projectId:number){
    this.router.navigate(['project-details', projectId]);

  }

  updateProject(projectId: number){
    this.router.navigate(['update-project', projectId]);
  }
  deleteProject (projectId: number){
    this.projectservice.deleteProject(projectId).subscribe(data =>{
   console.log(data);
      this.getProjects();
    })
  }

  getData(){
    /*this.httpclient.get<UserInterface>("http://localhost:8080/auth/users")*/
  }

}


