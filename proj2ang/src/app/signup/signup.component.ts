import {Component} from '@angular/core';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  signupForm = this.fb.group({
    email: [''],
    firstname: [''],
    lastname: ['']
  });

  constructor(private fb: FormBuilder) {
  }
}
