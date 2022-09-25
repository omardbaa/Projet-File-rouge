import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Meeting } from '../models/meeting-interface/meeting';

@Injectable({
  providedIn: 'root'
})
export class MeetingService {


  private baseURL = "http://localhost:8080/meeting";
  constructor(private httpClient: HttpClient) { }

getMeetingList():Observable<Meeting[]>{

  return this.httpClient.get<Meeting[]>(`${this.baseURL}`);
}

createMeeting(meeting:Meeting): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, meeting);
}

getMeetingById(meetingId: number): Observable<Meeting>{
  return this.httpClient.get<Meeting>(`${this.baseURL}/${meetingId}`);
}

updateMeeting(meetingId:number, meeting: Meeting): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${meetingId}`,meeting);
}

deleteMeeting(meetingId: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${meetingId}`);

}


getAllEmployees(meetingId: number): Observable<Meeting>{
  return this.httpClient.get<Meeting>(`${this.baseURL}/${meetingId}`+'/employees');
}

}