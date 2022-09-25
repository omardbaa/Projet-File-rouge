import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MeetingService } from '../meeting-service/meeting.service';
import { Employee } from '../models/employee';
import { Meeting } from '../models/meeting-interface/meeting';

@Component({
  selector: 'app-meeting-details',
  templateUrl: './meeting-details.component.html',
  styleUrls: ['./meeting-details.component.css']
})
export class MeetingDetailsComponent implements OnInit {


  


  allEmployees: any = [];
  
 meetingId!: number;
  meeting: Meeting = new Meeting;
  
  employee: Employee= new Employee;
  
  userId!:number;
  
  
  
    constructor(private meetingService: MeetingService , private route: ActivatedRoute) { }
  
    
  
    ngOnInit(): void {
      this.meetingId = this.route.snapshot.params['id'];
      this.meeting = new Meeting();
      this.meetingService.getMeetingById(this.meetingId).subscribe(data => {
        this.meeting = data;
  
        this.getEmployees();
      });
  
  
  
    }
  
  
    private getEmployees(){
      this.meetingService.getAllEmployees(this.meetingId).subscribe(data =>{
        this.allEmployees = data;
      });
    }
    
  
  }
  
