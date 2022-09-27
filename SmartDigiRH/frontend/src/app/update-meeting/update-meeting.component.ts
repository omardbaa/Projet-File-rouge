import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MeetingService } from '../meeting-service/meeting.service';
import { Meeting } from '../models/meeting-interface/meeting';

@Component({
  selector: 'app-update-meeting',
  templateUrl: './update-meeting.component.html',
  styleUrls: ['./update-meeting.component.css']
})
export class UpdateMeetingComponent implements OnInit {



  meetingId!: number;
  meeting: Meeting = new Meeting();
  constructor(private meetingSerive: MeetingService, 
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.meetingId = this.route.snapshot.params['id'];
    this.meetingSerive.getMeetingById(this.meetingId).subscribe(data =>{
      this.meeting = data;
    },error => console.log(error));
    
    }
   
    onSubmit(){
      this.meetingSerive.updateMeeting(this.meetingId, this.meeting).subscribe(data =>{
        this.goToMeetingList();
      },
         error => console.log(error));
     
  
    }

    goToMeetingList(){
      this.router.navigate(['admin/meetings']);
  
    }
  }

