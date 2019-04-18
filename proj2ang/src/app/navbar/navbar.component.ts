import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/user.model';
import { UsersService } from '../../services/user.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  loginForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder,
    private usersService: UsersService) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
   });
  }

  checkLogin() {
    let email = this.loginForm.get('email').value;
    let password = this.loginForm.get('password').value;
    var id = null;
    // console.log(email);
    // console.log(password);

    let promise = new Promise<User>((resolve) => {
      resolve(this.usersService.getUser(email, password));
    });

  }
}
