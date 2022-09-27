import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Account/login/login.component';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import { CreateMeetingComponent } from './create-meeting/create-meeting.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { CreateTrainingComponent } from './create-training/create-training.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { CreateVacationComponent } from './create-vacation/create-vacation.component';
import { AuthenticationGuard } from './guards/authentication.guard';
import { HomeComponent } from './home/home.component';
import { MeetingDetailsComponent } from './meeting-details/meeting-details.component';
import { MeetingListComponent } from './meeting-list/meeting-list.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { TrainingDetailsComponent } from './training-details/training-details.component';
import { TrainingListComponent } from './training-list/training-list.component';
import { UpdateMeetingComponent } from './update-meeting/update-meeting.component';
import { UpdateProjectComponent } from './update-project/update-project.component';
import { UpdateTrainingComponent } from './update-training/update-training.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UpdateVacationComponent } from './update-vacation/update-vacation.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserListComponent } from './user-list/user-list.component';
import { VacationDetailsComponent } from './vacation-details/vacation-details.component';
import { VacationListComponent } from './vacation-list/vacation-list.component';


const routes: Routes = [



{path:'',redirectTo: 'home', pathMatch: 'full'},
{path: 'admin', component: AdminTemplateComponent, canActivate:[AuthenticationGuard],
children:[ 
  {path: 'login', component: LoginComponent},

{path: 'home', component: HomeComponent},


{path: 'users', component: UserListComponent},
{path: 'create-user', component: CreateUserComponent},
{path: 'update-user/:id', component: UpdateUserComponent},
{path: 'user-details/:id', component: UserDetailsComponent},

{path: 'projects', component: ProjectListComponent},
{path: 'create-project', component:CreateProjectComponent},
{path: 'update-project/:id',component: UpdateProjectComponent},
{path: 'project-details/:id', component: ProjectDetailsComponent},

{path: 'meetings', component: MeetingListComponent},
{path: 'create-meeting', component : CreateMeetingComponent},
{path: 'update-meeting/:id', component: UpdateMeetingComponent},
{path: 'meeting-details/:id', component: MeetingDetailsComponent},

{path: 'vacations', component: VacationListComponent},
{path: 'create-vacation', component: CreateVacationComponent},
{path: 'update-vacation/:id', component: UpdateVacationComponent},
{path: 'vacation-details/:id',component: VacationDetailsComponent},

{path: 'trainings', component: TrainingListComponent},
{path: 'create-training', component: CreateTrainingComponent},
{path: 'update-training/:id', component: UpdateTrainingComponent},
{path: 'training-details/:id', component: TrainingDetailsComponent},


]},





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
