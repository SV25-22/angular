import { Component, Input } from '@angular/core';
import { CommonModule, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterOutlet } from '@angular/router';
import { CurrentUserService } from '../current-user.service';

export class User {
  name: string;
  surname: string;
  username: string;
  password: string;
  isAdmin: boolean;

  constructor(name: string, surname: string, username: string, password: string, isAdmin: boolean) {
    this.name = name;
    this.surname = surname;
    this.username = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }
}

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  imports: [RouterOutlet,FormsModule,CommonModule,NgIf],

})
export class LoginComponent {
  @Input() user: any;
  greeting: string = 'Welcome!';
  username: string = "";
  password: string = "";
  invalidLogin: boolean = false;
  dummyValues: Map<string, User> = new Map<string, User>();

  constructor(private router: Router, private currentUserService: CurrentUserService) {
    this.username = "";
    this.password = "";
    this.invalidLogin = false;
    const user1 = new User("John", "Doe", "username1", "password1", false);
    const user2 = new User("Jane", "Doe", "username2", "password2", false);
    const adminUser = new User("Admin", "Admin", "admin", "admin123", true);

    this.dummyValues.set(user1.username, user1);
    this.dummyValues.set(user2.username, user2);
    this.dummyValues.set(adminUser.username, adminUser);
  }

  login(){
    console.log(this.username);
    console.log(this.password);
    console.log(this.invalidLogin);
    var user = this.dummyValues.get(this.username);
    if (this.dummyValues.has(this.username) && this.dummyValues.get(this.username)?.password === this.password) {
      this.invalidLogin = false;
      this.currentUserService.setCurrentUser(user);
      if(user?.isAdmin){
        console.log(user)
        console.log("Admin logged in");
        this.router.navigate(['/admin/users']);
      }else{
        console.log("user logged in") //TODO
      }
    } else {
      this.invalidLogin = true;
    }

  }
}
