import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-manager-request-list',
  templateUrl: './manager-request-list.component.html',
  styleUrls: ['./manager-request-list.component.scss']
})
export class ManagerRequestListComponent implements OnInit {

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    let url = "http://localhost:8087/requests/open"
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
                    let emp = headers.insertCell();
                    emp.appendChild(document.createTextNode("Employee"));
                    let type = headers.insertCell();
                    type.appendChild(document.createTextNode("Type"));
                    let amount = headers.insertCell();
                    amount.appendChild(document.createTextNode("Amount Requested"));
                }

                for( let i = 0; i < count; i ++) {
                  let row = table.insertRow();

                  let button = document.createElement('button');
                  button.type = 'button';
                  button.innerHTML = "View";

                  button.onclick = function() {
                      sessionStorage.setItem("request", requestObject[i].id);
                      window.location.assign("requestViewManager.html");
                  }

                  let desc = row.insertCell();
                  desc.appendChild(button);
                  desc.classList.add("table-element");

                  let emp = row.insertCell();
                  emp.appendChild(document.createTextNode(requestObject[i].uID));
                  emp.classList.add("table-element");

                  let type = row.insertCell();
                  type.appendChild(document.createTextNode(requestObject[i].category));
                  type.classList.add("table-element");

                  let amount = row.insertCell();
                  amount.appendChild(document.createTextNode(("$" + parseInt(requestObject[i].owedAmount) / 100)));
                  amount.classList.add("table-element");
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
