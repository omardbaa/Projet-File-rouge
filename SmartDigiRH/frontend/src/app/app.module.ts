import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateUserComponent } from './create-user/create-user.component';
import { FormsModule } from '@angular/forms';
import { UserListComponent } from './user-list/user-list.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { UpdateProjectComponent } from './update-project/update-project.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { CreateTrainingComponent } from './create-training/create-training.component';
import { TrainingDetailsComponent } from './training-details/training-details.component';
import { TrainingListComponent } from './training-list/training-list.component';
import { UpdateTrainingComponent } from './update-training/update-training.component';
import { CreateMeetingComponent } from './create-meeting/create-meeting.component';
import { UpdateMeetingComponent } from './update-meeting/update-meeting.component';
import { MeetingListComponent } from './meeting-list/meeting-list.component';
import { MeetingDetailsComponent } from './meeting-details/meeting-details.component';
import { CreateVacationComponent } from './create-vacation/create-vacation.component';
import { UpdateVacationComponent } from './update-vacation/update-vacation.component';
import { VacationDetailsComponent } from './vacation-details/vacation-details.component';
import { VacationListComponent } from './vacation-list/vacation-list.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { HomeComponent } from './home/home.component';
import { EmployeeSpaceComponent } from './employee-space/employee-space.component';
import { LoginComponent } from './Account/login/login.component';
@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    CreateUserComponent,
    UpdateUserComponent,
    UserDetailsComponent,
    CreateProjectComponent,
    UpdateProjectComponent,
    ProjectListComponent,
    ProjectDetailsComponent,
    CreateTrainingComponent,
    TrainingDetailsComponent,
    TrainingListComponent,
    UpdateTrainingComponent,
    CreateMeetingComponent,
    UpdateMeetingComponent,
    MeetingListComponent,
    MeetingDetailsComponent,
    CreateVacationComponent,
    UpdateVacationComponent,
    VacationDetailsComponent,
    VacationListComponent,
    HomeComponent,
    EmployeeSpaceComponent,
    LoginComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, 
    FormsModule, 
    NgxPaginationModule, 
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
