import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginUserService {

  constructor(private http: HttpClient) { }

  getUser(username: string, password: string): Observable<any> {
    const url = `http://localhost:8080/users/${username}/${password}`;
    
    return this.http.get<any>(url);
  }
}
