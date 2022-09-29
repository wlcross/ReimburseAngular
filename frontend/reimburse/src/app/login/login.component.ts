import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username ="";
  pass = "";
  error ="";

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
  }

  login() {
    let url = "http://localhost:8087/login";
    let creds = {'username': this.username, 'password': this.pass};
    let uidsub = (this.http.post(url, creds)).subscribe (
    e => {
        //console.log(e);
        let uid = JSON.stringify(e);
        //console.log(uid);
        if (e == "-1") {
          this.error = "Invalid Credentials";
          return;
        }
        sessionStorage.setItem("UID", uid);
        this.router.navigate(['homepage'])
    }
    );

    this.error = "Invalid Credentials";
  }

  register() {
    this.router.navigate(['register']);
  }

}
