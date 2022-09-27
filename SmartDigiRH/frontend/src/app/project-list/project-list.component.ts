import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Employee } from "../models/employee";
import { Project } from "../models/project-interface/project";
import { ProjectServiceService } from "../project-service/project-service.service";
import { UserService } from "../user-service/user.service";

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




  employee: Employee= new Employee;
  allEmployees: any = [];


projects: Project [] = [];
projetId!:number;

userId!: number;
  user: Employee = new Employee;

  constructor(private projectservice: ProjectServiceService, private router:Router, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.getProjects();
  }

  private getProjects(){
    this.projectservice.getProjectList().subscribe(data =>{
      this.projects = data;
    });
  }

  projectDetails(projectId:number){
    this.router.navigate(['admin/project-details', projectId]);

  }

  updateProject(projectId: number){
    this.router.navigate(['admin/update-project', projectId]);
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


  


  // userDetails(userId:number){
  //   this.router.navigate(['user-details', userId]);

  // }

}


