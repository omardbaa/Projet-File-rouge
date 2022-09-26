import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountServiceService } from '../account-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userFormGroup!: FormGroup;

  errorMessage : any;

  constructor(private formBuilder: FormBuilder, private accountService: AccountServiceService, private router: Router) { }

  ngOnInit(): void {
    this.userFormGroup=this.formBuilder.group({

      username: this.formBuilder.control(""),
      password: this.formBuilder.control(""),

    });
  }

  handleLogin(){

    let username = this.userFormGroup.value.username;

    let password = this.userFormGroup.value.password;
    this.accountService.login(username, password).subscribe({
      next :(appUser) => {
        this.accountService.authenticateUser(appUser).subscribe({
               next : (data)=>{
                this.router.navigateByUrl("/home");

               }
         });
      
 
      },
      error : (err)=>{

        this.errorMessage=err;
      }

      });
  }


}
