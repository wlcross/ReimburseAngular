import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-request-view',
  templateUrl: './request-view.component.html',
  styleUrls: ['./request-view.component.scss']
})
export class RequestViewComponent implements OnInit {

  category = "";
  value = "";
  requested = "";
  owed = "";
  status = "";

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    let url = "http://localhost:8087/request/" + sessionStorage.getItem("request");
    let uidsub = (this.http.get(url)).subscribe (
      e => {
          console.log(e);
  
          let requestObject = JSON.parse(JSON.stringify(e));
  
          this.category = "Category: " + requestObject.category + "<br>";
          this.value = "Value: " + requestObject.value + "<br>";
          this.requested = "Requested Amount: " + requestObject.requestedAmount + "<br>";
          if (requestObject.requestedAmount != requestObject.owedAmount) this.owed = "Owed Amount: " + requestObject.owedAmount + "<br>";
          if (requestObject.closed == true) {
            if (requestObject.accepted == true) {
              this.status = "Status: Accepted By ManagerID " + requestObject.managerID;
            } else {
              this.status = "Status: Rejected By ManagerID " + requestObject.managerID;
            }
          } else {
            this.status = "Status: Open";
          }
          
          //this.router.navigate(['homepage'])
  
          
              
      }
      );
  }




  logout() {
    this.router.navigate(['login']);
  }

  homepage() {
    this.router.navigate(['homepage']);
  }

}
