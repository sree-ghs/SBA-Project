import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from 'src/app/home-page/home-page.component';
import { LoginComponent } from 'src/app/login/login.component';
import { RegistrationPageComponent } from 'src/app/registration-page/registration-page.component';
import { UserHomePageComponent } from 'src/app/user-home-page/user-home-page.component';
import { CanActivateRouteGuard } from 'src/app/Services/can-activate-route.guard';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegistrationPageComponent },
  { path: 'loginUserHome', component: UserHomePageComponent, canActivate: [CanActivateRouteGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

  
}
