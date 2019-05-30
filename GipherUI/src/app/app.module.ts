import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { HomePageService } from 'src/app/home-page/home-page.service';
import { Routes } from '@angular/router';
import { RouterModule } from '@angular/router';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { UserHomePageComponent } from './user-home-page/user-home-page.component';
import { UserHomePageService } from 'src/app/user-home-page/user-home-page.service';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { RegistrationPageService } from 'src/app/registration-page/registration-page.service';
import { CanActivateRouteGuard } from 'src/app/Services/can-activate-route.guard';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomePageComponent,
    RegistrationPageComponent,
    UserHomePageComponent
  ],
  imports: [
    BrowserModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    HomePageService,
    UserHomePageService,
    AuthenticationService,
    RegistrationPageService,
    CanActivateRouteGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
