import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-homepage',
  templateUrl: './manager-homepage.component.html',
  styleUrls: ['./manager-homepage.component.scss']
})
export class ManagerHomepageComponent implements OnInit {

  user = "";
  greeting = "";
  remaining = "";
  openRequests = "";

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    let url = "http://localhost:8087/user/";
    let uidsub = (this.http.get(url + sessionStorage.getItem("UID"))).subscribe (
    e => {
        console.log(e);

        this.user = JSON.stringify(e);

        let userObject = JSON.parse(this.user);

        if (userObject.manager == true) {
          this.router.navigate(['managerhomepage']);
        }
        
        //this.router.navigate(['homepage'])

        this.greeting = "Hello " + userObject.firstName + "!";
        this.remaining = "You have $" + (userObject.remaining / 100) + " remaining.";
    }
    );

    url = "http://localhost:8087/requests/open"
    uidsub = (this.http.get(url)).subscribe (
      e => {
          console.log(e);
  
          let requestObject = JSON.parse(JSON.stringify(e));
  
          let count = requestObject.length;
          
          //this.router.navigate(['homepage'])
  
          this.openRequests = "There are " + count + " open requests!";
      }
      );
  }

  viewManagerRequests() {
    this.router.navigate(['managerrequestlist']);
  }

  viewRequests() {
    this.router.navigate(['requestlist']);
  }

  createRequest() {
    this.router.navigate(['createrequest']);
  }

  logout() {
    sessionStorage.clear;
    this.greeting = "";
    this.remaining = "";
    this.openRequests = "";
    this.router.navigate(['login']);
  }

}
