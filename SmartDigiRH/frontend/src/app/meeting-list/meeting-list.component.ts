import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MeetingService } from '../meeting-service/meeting.service';
import { Meeting } from '../models/meeting-interface/meeting';

@Component({
  selector: 'app-meeting-list',
  templateUrl: './meeting-list.component.html',
  styleUrls: ['./meeting-list.component.css']
})
export class MeetingListComponent implements OnInit {

  pageSize = 0;
  perPage = 4;
  p: number = 1;
  title = '';
  meetingId = '';


  meetings: Meeting [] = [];

  constructor(private meetingService: MeetingService, private router:Router) { }

  ngOnInit(): void {

    this.getMeetings();
  }

  private getMeetings(){
    this.meetingService.getMeetingList().subscribe(data =>{
      this.meetings = data;
    });
  }

  meetingDetails(meetingId:number){
    this.router.navigate(['admin/meeting-details', meetingId]);

  }

  updateMeeting(meetingId: number){
    this.router.navigate(['admin/update-meeting', meetingId]);
  }
  deleteMeeting (meetingId: number){
    this.meetingService.deleteMeeting(meetingId).subscribe(data =>{
   console.log(data);
      this.getMeetings();
    })
  }

  getData(){
    /*this.httpclient.get<UserInterface>("http://localhost:8080/auth/users")*/
  }

}
