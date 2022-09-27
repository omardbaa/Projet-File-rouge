import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MeetingService } from '../meeting-service/meeting.service';
import { Meeting } from '../models/meeting-interface/meeting';

@Component({
  selector: 'app-create-meeting',
  templateUrl: './create-meeting.component.html',
  styleUrls: ['./create-meeting.component.css']
})
export class CreateMeetingComponent implements OnInit {
  meeting: Meeting = new Meeting();
  constructor(private meetingService: MeetingService, 
    private router: Router) { }

  ngOnInit(): void {
  }

  saveMeeting(){
this.meetingService.createMeeting(this.meeting).subscribe(data => {
  console.log(data);
  this.goToMeetingList();

},
  error => console.log(error));
}

goToMeetingList(){
    this.router.navigate(['admin/meetings']);

  }

  onSubmit(){
    console.log(this.meeting);
    this.saveMeeting()
    this.goToMeetingList();

  }

}
