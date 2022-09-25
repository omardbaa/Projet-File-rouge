import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../models/employee';
import { UserService } from '../user-service/user.service';


@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  userId!: number;
  user: Employee = new Employee;
  constructor(private userService: UserService , private route: ActivatedRoute) { }

  

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['id'];
    this.user = new Employee();
    this.userService.getUserById(this.userId).subscribe(data => {
      this.user = data;
    });
  }

}
