import { Component, OnInit } from '@angular/core';
import { User } from '../User/user';
import { UserService } from '../user-service/user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
user: User = new User();
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
    this.router.navigate(['/users']);

  }

  onSubmit(){
    console.log(this.user);
    this.saveUser()
    this.goToUserList();

  }

}
