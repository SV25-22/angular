import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { User } from './login/login.component';

@Injectable({
  providedIn: 'root'
})
export class CreateUserService {

  constructor(private http: HttpClient) { }

  addUser(user: User): Observable<any>{
    const url = `http://localhost:8080/users`;
    return this.http.post<any>(url,user).pipe(
      catchError(error=>{
        console.error("Error adding user",error);
        throw error;
      })
    );

  }

}
