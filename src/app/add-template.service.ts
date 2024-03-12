import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Template } from './add-template/add-template.component';
import { Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddTemplateService {

  constructor(private http: HttpClient) { }

  addTemplate(template: Template): Observable<any>{
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const url = `http://localhost:8080/templates`;;
    console.log("no error here")
    return this.http.post<any>(url,template,{headers: headers}).pipe(
      catchError(error=>{
        console.error("Error adding template",error);
        throw error;
      })
    )
  }

}
