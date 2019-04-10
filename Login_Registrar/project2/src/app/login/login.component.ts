import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
export class LoginComponent implements OnInit{
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;

  ngOnInit() {
    // get return url from route parameters or default to '/'
  }
  onSubmit() {
    this.submitted = true;
    this.loading = true;
  }
}

