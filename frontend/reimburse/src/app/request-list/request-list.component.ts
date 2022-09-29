import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-manager-request-list',
  templateUrl: './request-list.component.html',
  styleUrls: ['./request-list.component.scss']
})
export class RequestListComponent implements OnInit {

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    let url = "http://localhost:8087/requests/user/" + sessionStorage.getItem("UID");
    let uidsub = (this.http.get(url)).subscribe (
      e => {
          console.log(e);
  
          let requestObject = JSON.parse(JSON.stringify(e));
  
          let count = requestObject.length;
          
          //this.router.navigate(['homepage'])
  
          var table = document.createElement('table');
                table.classList.add('table-bordered');
                table.classList.add('tablespace');
                let headers = table.insertRow();
                {
                    let link = headers.insertCell();
                    link.appendChild(document.createTextNode("Link"));
                    let type = headers.insertCell();
                    type.appendChild(document.createTextNode("Type"));
                    let amount = headers.insertCell();
                    amount.appendChild(document.createTextNode("Amount Requested"));
                    let approval = headers.insertCell();
                    approval.appendChild(document.createTextNode("Approval"));
                }

                for( let i = 0; i < count; i ++) {
                  let row = table.insertRow();

                  let button = document.createElement('button');
                  button.type = 'button';
                  button.innerHTML = "View";

                  button.onclick = function() {
                      sessionStorage.setItem("request", requestObject[i].rid);
                      window.location.assign("requestViewManager.html");
                  }

                  let desc = row.insertCell();
                  desc.appendChild(button);
                  desc.classList.add("table-element");

                  let type = row.insertCell();
                  type.appendChild(document.createTextNode(requestObject[i].category));
                  type.classList.add("table-element");

                  let amount = row.insertCell();
                  amount.appendChild(document.createTextNode(("$" + parseInt(requestObject[i].owedAmount) / 100)));
                  amount.classList.add("table-element");

                  let approval = row.insertCell();
                  let approvalStatus = "Open";
                  if (requestObject[i].closed == true) {
                    if (requestObject[i].accepted == true) {
                      approvalStatus = "Accepted";
                    } else {
                      approvalStatus = "Rejected";
                    }
                  }
                  approval.appendChild(document.createTextNode(approvalStatus));
                  approval.classList.add("table-element");
                }
              let tableSpace = document.getElementById("tableSpace");
              if (tableSpace != null) {
                tableSpace.appendChild(table);
              }
              
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
