import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project} from '../models/project-interface/project';
import { ProjectServiceService } from '../project-service/project-service.service';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {

  project: Project = new Project();
  constructor(private projectService: ProjectServiceService, 
    private router: Router) { }

  ngOnInit(): void {
  }

  saveProject(){
this.projectService.createProject(this.project).subscribe(data => {
  console.log(data);
  this.goToProjectList();

},
  error => console.log(error));
}

goToProjectList(){
    this.router.navigate(['admin/projects']);

  }

  onSubmit(){
    console.log(this.project);
    this.saveProject()
    this.goToProjectList();

  }

}
