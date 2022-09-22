import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../models/project-interface/project';
import { ProjectServiceService } from '../project-service/project-service.service';

@Component({
  selector: 'app-update-project',
  templateUrl: './update-project.component.html',
  styleUrls: ['./update-project.component.css']
})
export class UpdateProjectComponent implements OnInit {

  projectId!: number;
  project: Project = new Project();
  constructor(private projectService: ProjectServiceService, 
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.projectId = this.route.snapshot.params['id'];
    this.projectService.getProjectById(this.projectId).subscribe(data =>{
      this.project = data;
    },error => console.log(error));
    
    }
   
    onSubmit(){
      this.projectService.updateProject(this.projectId, this.project).subscribe(data =>{
        this.goToProjectList();
      },
         error => console.log(error));
     
  
    }

    goToProjectList(){
      this.router.navigate(['/projects']);
  
    }
  }

