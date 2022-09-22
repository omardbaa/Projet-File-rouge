import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../user-service/user.service';


@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  userId!: number;
  user: User = new User;
  constructor(private userService: UserService , private route: ActivatedRoute) { }

  

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['id'];
    this.user = new User();
    this.userService.getUserById(this.userId).subscribe(data => {
      this.user = data;
    });
  }

}
