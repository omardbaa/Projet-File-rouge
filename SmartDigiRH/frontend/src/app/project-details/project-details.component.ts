import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../models/employee';
import { Project } from '../models/project-interface/project';
import { ProjectServiceService } from '../project-service/project-service.service';
import { UserService } from '../user-service/user.service';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})
export class ProjectDetailsComponent implements OnInit {

  


allEmployees: any = [];

projectId!: number;
project: Project = new Project;

employee: Employee= new Employee;

userId!:number;



  constructor(private projectService: ProjectServiceService , private route: ActivatedRoute) { }

  

  ngOnInit(): void {
    this.projectId = this.route.snapshot.params['id'];
    this.project = new Project();
    this.projectService.getProjectById(this.projectId).subscribe(data => {
      this.project = data;

      this.getEmployees();
    });



  }


  private getEmployees(){
    this.projectService.getAllEmployees(this.projectId).subscribe(data =>{
      this.allEmployees = data;
    });
  }
  

}
