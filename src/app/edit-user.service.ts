import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './login/login.component';
import { Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EditUserService {

  constructor(private http: HttpClient) { }

  editUser(username: String,user: User): Observable<any>{
    const url = `http://localhost:8080/users/${username}`;
    return this.http.put<any>(url,user).pipe(
      catchError(error =>{
        console.error("Error editing user",error);
        throw error;
      })
    )
  }
}
