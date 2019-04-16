import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

import { AuthenticationService } from 'src/services/authentication.service';
// This guard will protect against the unauthorized access of certain pages to common users.
// REMEMBER: still voulnerable to browser dev tools; requrie authentication tokens to bypass this issue

@Injectable({
  providedIn: 'root'
})
export class AuthorizationGuard implements CanActivate {
  constructor(private router: Router, private authenticationService: AuthenticationService) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const currentUser = this.authenticationService.loggedinUserValue;
    if (currentUser){
      return true;
    } else {
      this.router.navigate(['/home'], {queryParams: { returnURL: state.url }});
      return false;
    }
  }






}
