import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {

  user = "";

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
    }
    );
  }

}
