import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../models/employee';
import { UserService } from '../user-service/user.service';


@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  userId!: number;
  user: Employee = new Employee();
  constructor(private userService: UserService, 
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['id'];
    this.userService.getUserById(this.userId).subscribe(data =>{
      this.user = data;
    },error => console.log(error));
    
    }
   
    onSubmit(){
      this.userService.updateUser(this.userId, this.user).subscribe(data =>{
        this.goToUserList();
      },
         error => console.log(error));
     
  
    }

    goToUserList(){
      this.router.navigate(['admin/users']);
  
    }
  }





