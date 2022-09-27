import { Component, OnInit } from '@angular/core';

import { UserService } from '../user-service/user.service';
import { Router } from '@angular/router';
import { Employee } from '../models/employee';
@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
user: Employee = new Employee();
  constructor(private userService: UserService, 
    private router: Router) { }

  ngOnInit(): void {
  }

  saveUser(){
this.userService.createUser(this.user).subscribe(data => {
  console.log(data);
  this.goToUserList();

},
  error => console.log(error));
}

  goToUserList(){
    this.router.navigate(['admin/users']);

  }

  onSubmit(){
    console.log(this.user);
    this.saveUser()
    this.goToUserList();

  }

}
