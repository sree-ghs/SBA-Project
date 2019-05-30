import { Component, OnInit, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class RegistrationPageService implements OnInit {

    private authUrl = 'http://localhost:8081/api/v1/auth';

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  
  getRegister(formValue){
    return this.http.post(this.authUrl + '/register', formValue,)
    
  }

}
