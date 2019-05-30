import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthenticationService {

  private authUrl = 'http://localhost:8081/api/v1/auth';
  constructor( public http: HttpClient ) { }


  register(data){
    return this.http.post<any>(`${this.authUrl}/register`, data, {
      headers: new HttpHeaders().set('Content-Type', `application/json`)
    })
  }

  authenticateUser(data) {
    //authenticateUser(data) {
   // console.log('data:', data); {userId:userId, userPassword:userPassword}
    //return this.http.post<any>(this.authUrl, data);
    console.log("hey");
    return this.http.post<any>(`${this.authUrl}/login`, data, {
      headers: new HttpHeaders().set('Content-Type', `application/json`)
    })
  }

  setBearerToken(token) {
    localStorage.setItem('bearerToken', token);
  }

  getBearerToken() {
    return localStorage.getItem('bearerToken');
  }

  setUserId(userId) {
    console.log("userId set", userId)
    localStorage.setItem('userId', userId);
  }

  getUserId() {
    return localStorage.getItem('userId');
  }

  isUserAuthenticated(token): Promise<boolean> {
    console.log('token' + token);
    return this.http.post(`${this.authUrl}/login/isAuthenticated`, {}, {
      headers: new HttpHeaders().set('Authorization', `Bearer ${token}`)
    })
    .map( (res) => res['isAuthenticated'] )
    .toPromise();
  }

  public isUserValid(token){
    return this.http.post(`${this.authUrl}/login/isAuthenticated`, {}, {
      headers: new HttpHeaders().set('authorization', `Bearer ${token}`)
    })
  }
}
