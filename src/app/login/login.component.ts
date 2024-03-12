import { Component, Input } from '@angular/core';
import { CommonModule, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterOutlet } from '@angular/router';
import { CurrentUserService } from '../current-user.service';
import { LoginUserService } from '../login-user.service';

export class User {
  name: string;
  surname: string;
  username: string;
  password: string;
  admin: boolean;

  constructor(name: string = "", surname: string = "", username: string = "", password: string = "", admin: boolean = false) {
    this.name = name;
    this.surname = surname;
    this.username = username;
    this.password = password;
    this.admin = admin;
  }
}

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  imports: [RouterOutlet,FormsModule,CommonModule],

})
export class LoginComponent {
  @Input() user: any;
  greeting: string = 'Welcome!';
  username: string = "";
  password: string = "";
  invalidLogin: boolean = false;


  constructor(private router: Router, private currentUserService: CurrentUserService, private loginUserService: LoginUserService) {
    this.username = "";
    this.password = "";
    this.invalidLogin = false;
  }

  login(){


    this.loginUserService.getUser(this.username,this.password).subscribe({
      next: (data) => {
        console.log(data);
        if(data === null){
          this.invalidLogin = true;
        }else{
          this.invalidLogin = false;
          this.currentUserService.setCurrentUser(data);
          if(data?.admin){
            console.log(data)
            console.log("Admin logged in");
            this.router.navigate(['/admin/users']);
          }else{
            console.log("user logged in") //TODO
          }
        }
      },
      error: (error) => {
        console.error(error); // Handle any errors here
        this.invalidLogin = true;
      }
    });


  }
}
