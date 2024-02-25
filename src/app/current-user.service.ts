import { Injectable } from '@angular/core';
import { User } from './login/login.component';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {
  private currentUser: any;
  setCurrentUser(user: any){
    this.currentUser = user;
  }
  getCurrentUser() : any{
    return this.currentUser;
  }
  constructor() { }
}
