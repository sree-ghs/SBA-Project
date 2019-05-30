import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { Router } from '@angular/router';

@Injectable()
export class CanActivateRouteGuard implements CanActivate {

  constructor(
    public authService: AuthenticationService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean  {
    console.log(typeof(this.authService.getBearerToken()), '--', this.authService.getBearerToken());

    if(this.authService.getBearerToken()!== null && this.authService.getBearerToken()!== ''){
      const booleanPromise = this.authService.isUserAuthenticated(this.authService.getBearerToken());
      console.log('booleanPromise: ', booleanPromise);
    return booleanPromise.then((authenticated) => {
      if (!authenticated) {
        console.log('Hello from Route Guard - to login');
        // this.routerService.routeToLogin();
        this.router.navigate(['login']);
      }
      authenticated = true;
      console.log('You are authenticated',authenticated);
      return authenticated;
    });
    }
    console.log('Redirecting to login');
    // this.routerService.routeToLogin();
    this.router.navigate(['login']);
     
  }
  }
