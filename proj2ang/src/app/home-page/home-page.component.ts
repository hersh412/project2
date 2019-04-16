import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {
  invalidLogin: boolean;

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  signIn(credentials) {
    this.authService.login(credentials)
      .subscribe(result => {
        if (result)
          this.router.navigate(['/account']);
        else
          this.invalidLogin = true;
      });
  }


}

