import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { User } from './login/login.component';

@Injectable({
  providedIn: 'root'
})
export class GetUsersService {
  private url = "http://localhost:8080/users";
  constructor(private http: HttpClient) { }
  getUsers(): Observable<Map<string, User>> {
    return this.http.get<User[]>(this.url).pipe(
      map(users => this.convertToMap(users))
    );
  }
  private convertToMap(users: User[]): Map<string,User>{
    const userMap = new Map<string, User>();
    users.forEach(user => {
      userMap.set(user.username, user);
    });
    return userMap;
  }
}
