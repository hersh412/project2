import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../auth.service';
import { Users } from '../model/user.model';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {
  invalidLogin: boolean;
  currentUser: Users;

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  signIn(credentials) {
    this.authService.login(credentials)
      .subscribe(result => {
        if (result) {
          this.currentUser = result as Users;
          console.log(this.currentUser);
          localStorage.setItem('currentUser', JSON.stringify(this.currentUser));
          this.router.navigate(['/customer']);
        } else {
          this.invalidLogin = true;
        }
      });
  }


}

