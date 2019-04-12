import { Component, OnInit } from '@angular/core';
//import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 // loginForm: FormGroup;
 // loading = false;
 // submitted = false;
 // returnUrl: string;

  constructor() {}

  ngOnInit() {
    // get return url from route parameters or default to '/'
  }
  onSubmit() {
  //  this.submitted = true;
  //  this.loading = true;
  }
}

