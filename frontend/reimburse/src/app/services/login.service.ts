import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
export class LoginService {

    constructor(private http:HttpClient) { }

    attemptLogin(username:String, pass:String) {
        let url = "http://localhost:8087/login";
        let creds = {'username': username, 'password': pass};
        let uidsub = (this.http.post(url, creds)).subscribe (
        e => {
            console.log(e);
        }
        );
    }
}