import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserInterface } from '../models/user-interface';
import { UserService } from '../user-service/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: UserInterface[] = [];

  constructor(private userService : UserService, private router: Router) { }

  ngOnInit(): void {

    this.getUsers();
  }

  private getUsers(){
    this.userService.getUsersList().subscribe(data =>{
      this.users = data;
    });
  }

  userDetails(id:number){
    this.router.navigate(['user-details', id]);

  }

  updateUser(id: number){
    this.router.navigate(['update-user', id]);
  }
  deleteUser (id: number){
    this.userService.deleteUser(id).subscribe(data =>{
   console.log(data);
      this.getUsers();
    })
  }

  getData(){
    /*this.httpclient.get<UserInterface>("http://localhost:8080/auth/users")*/
  }

}
