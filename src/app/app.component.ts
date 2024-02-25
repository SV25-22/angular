import { CommonModule, NgIf,NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,FormsModule,CommonModule,NgIf],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  greeting = 'Welcome!';
  username = "";
  password = "";
  invalidLogin = false;
  dummyValues = new Map<string, string>([
    ["username1", "password1"],
    ["username2", "password2"],
    ["username3", "password3"]
  ]);
  constructor(){}
  login(){
    if(this.dummyValues.has(this.username) && this.dummyValues.get(this.username) === this.password){
      this.invalidLogin = false;
    }else{
      this.invalidLogin = true;
    }
    console.log(this.username)
    console.log(this.password)
    console.log(this.invalidLogin)
  }
}
