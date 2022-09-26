import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { Employee } from '../models/employee';



@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {
users: Employee[]=[];
authenticatedUer : Employee | undefined;

  constructor() {

    this.users.push({
      username: "omarDb1", password: "123", roles: ["ADMIN","EMPLOYEE"],
      userId: 0,
      firstName: '',
      lastName: '',
      photo: '',
      email: '',
      phone: '',
      birthday: new Date,
      country: '',
      city: '',
      address: '',
      active: true,
      type: '',
      post: '',
      contrat: '',
      salary: '',
      idUser: 0
    });



    this.users.push({
      username: "saidAhmed", password: "123", roles: ["EMPLOYEE"],
      userId: 0,
      firstName: '',
      lastName: '',
      photo: '',
      email: '',
      phone: '',
      birthday: new Date,
      country: '',
      city: '',
      address: '',
      active: true,
      type: '',
      post: '',
      contrat: '',
      salary: '',
      idUser: 0
    });

}


public login(username : string, password:string):Observable<Employee>{

 let appUser = this.users.find(u => u.username==username);

 if (!appUser) return throwError(()=> new Error("User not Found"));
 
if (appUser.password!=password){return throwError(()=> new Error("username or password incorrect please try again"));
    
   }

   return of(appUser);
  }




  public authenticateUser(appUser:Employee):Observable<Boolean>{
    this.authenticatedUer =appUser;
    localStorage.setItem("authUser", JSON.stringify({username:appUser.username,  roles:appUser.roles,
    jwt:"JWT_TOKEN"
    }))
    return of (true);
  }



public hasRole(role: string) : boolean{
return  this.authenticatedUer!.roles.includes(role);

}


public isAuthenticated (){

return this.authenticatedUer!= undefined;

}

}
