import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DeleteUserService {
  constructor(private http: HttpClient) { }

  deleteUser(username: string): Observable<any>{
    const url = `http://localhost:8080/users/${username}`;
    return this.http.delete<any>(url);
  }
}
