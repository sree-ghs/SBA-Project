import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { AuthenticationService } from '../Services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = new FormControl('', Validators.required);
  password = new FormControl('', Validators.required);
  submitErrorMessage: String = '';
  private bearerToken: any;
  public usernameInvalid: boolean;
  public passwordInvalid: boolean;

  constructor(private router: Router, private authService: AuthenticationService) { }

  ngOnInit() {
  }

  openRegistrationPage(){
    this.username.patchValue('');
    this.password.patchValue('');
    this.router.navigate(['register']);
  }

  logInUserHomePage(){
    if(this.username.value !== null && this.username.value !== '' && this.username.value != undefined &&
    this.password.value !== null && this.password.value !== '' && this.password.value != undefined) {
      this.usernameInvalid = false;
      this.passwordInvalid = false;
      const loginData = { userId: this.username.value, userPassword: this.password.value };
      this.authService.authenticateUser(loginData).subscribe(
        responseObj => {
          this.bearerToken = responseObj['token'];
          this.authService.setBearerToken(this.bearerToken);        
          this.authService.setUserId(loginData.userId);
          //alert(`Welcome ${this.authService.getUserId()}`);
          this.submitErrorMessage = '';
          console.log("Routing to dashboard from login")
          this.router.navigate(['loginUserHome']);
        },
        errorObj => {
          this.submitErrorMessage = "Incorrect Username and Password!";
          console.log("Incorrect Username and Password");
          // this.router.navigate(['register']);
        }
      );
  } else {
    this.usernameInvalid = true;
    this.passwordInvalid = true;
  }
}

  checkUsername(){
    if(this.username.value !== null && this.username.value !== '' && this.username.value != undefined){
      this.usernameInvalid = false;
    } else {
      this.usernameInvalid = true;
    }
  }
  checkPassword(){
    if(this.password.value !== null && this.password.value !== '' && this.password.value != undefined){
      this.passwordInvalid = false;
    } else {
      this.passwordInvalid = true;
    }
  }
}
