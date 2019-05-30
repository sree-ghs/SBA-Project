import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';

import { RegistrationPageService } from './registration-page.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {
  public registerForm = new FormGroup({
    firstname: new FormControl('', Validators.required,),
    lastname: new FormControl('', Validators.required),
    username: new FormControl('', Validators.compose([Validators.required, Validators.minLength(5)])),
    email: new FormControl('', Validators.required),
    password:  new FormControl('', Validators.compose([Validators.required, Validators.minLength(5)])),
  })
  public submitErrorMessage: String ='';

  constructor(private router: Router, private registrationPageService: RegistrationPageService) { }

  ngOnInit() {
  }

  
  openLoginInPage(){
    this.router.navigate(['login']);
  }
  
  afterRegistration(){
    console.log('this.registerForm.valid - ' + this.registerForm.valid);
    if(this.registerForm.valid){
      const formValue = {userId: this.registerForm.get('username').value, userPassword: this.registerForm.get('password').value,
      firstName: this.registerForm.get('firstname').value, lastName: this.registerForm.get('lastname').value, 
      email: this.registerForm.get('email').value};

      this.registrationPageService.getRegister(formValue).subscribe( res => {
        console.log(res);
        this.router.navigate(['login']);
        }, err => {
          
          this.submitErrorMessage = "Try Different Username!"; 
          console.log(this.submitErrorMessage);
        });
    } else {
      this.submitErrorMessage = 'Please enter value to all the fields!'; 
    }
    
    
  }

  reset(){
    this.registerForm.patchValue({
      firstname: '',
      lastname: '',
      username: '',
      email: '',
      password:  '',
    });
    this.submitErrorMessage = '';
  }
}
