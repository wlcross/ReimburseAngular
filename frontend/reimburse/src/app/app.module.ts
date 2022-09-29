import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomepageComponent } from './homepage/homepage.component';
import { RequestListComponent } from './request-list/request-list.component';
import { RequestViewComponent } from './request-view/request-view.component';
import { ManagerHomepageComponent } from './manager-homepage/manager-homepage.component';
import { ManagerRequestListComponent } from './manager-request-list/manager-request-list.component';
import { ManagerRequestViewComponent } from './manager-request-view/manager-request-view.component';
import { CreateRequestComponent } from './create-request/create-request.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomepageComponent,
    RequestListComponent,
    RequestViewComponent,
    ManagerHomepageComponent,
    ManagerRequestListComponent,
    ManagerRequestViewComponent,
    CreateRequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule, 
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
