import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomepageComponent } from './homepage/homepage.component';
import { RequestListComponent } from './request-list/request-list.component';
import { RequestViewComponent } from './request-view/request-view.component';
import { ManagerHomepageComponent } from './manager-homepage/manager-homepage.component';
import { ManagerRequestListComponent } from './manager-request-list/manager-request-list.component';
import { ManagerRequestViewComponent } from './manager-request-view/manager-request-view.component';
import { CreateRequestComponent } from './create-request/create-request.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'homepage', component: HomepageComponent},
  {path: 'requestlist', component: RequestListComponent},
  {path: 'requestview', component: RequestViewComponent},
  {path: 'managerhomepage', component: ManagerHomepageComponent},
  {path: 'managerrequestlist', component: ManagerRequestListComponent},
  {path: 'managerrequestview', component: ManagerRequestViewComponent},
  {path: 'createrequest', component: CreateRequestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
