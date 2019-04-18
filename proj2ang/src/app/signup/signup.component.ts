import {Component} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {User} from '../model/user.model';
import {PasswordValidators} from './password.validators';
import {UsersService} from '../../services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  providers: [UsersService]
})
export class SignupComponent {

  signupForm = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    firstname: ['', Validators.required],
    lastname: ['', Validators.required],
    address: ['', Validators.required],
    address2: ['', Validators.required],
    city: ['', Validators.required],
    state: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(2)]],
    zipcode: ['', Validators.required],
    phone: ['', Validators.required],
    gender: ['', Validators.required],
    password: ['', Validators.required],
    confirmpw: ['', Validators.required]
  });


  constructor(private fb: FormBuilder, private userService: UsersService) {
  }

  onSubmit() {
   let u: User = new User();
    u.email = this.signupForm.controls.email.value;
    u.password = this.signupForm.controls.password.value;
    u.userconf = 1;
    u.fName = this.signupForm.controls.firstname.value;
    u.lName = this.signupForm.controls.lastname.value;
    u.address1 = this.signupForm.controls.address.value;
    u.address2 = this.signupForm.controls.address2.value;
    u.city = this.signupForm.controls.city.value;
    u.state = this.signupForm.controls.state.value;
    u.zipcode = this.signupForm.controls.zipcode.value;
    u.isMale = this.signupForm.controls.zipcode.value === 'Male';

   console.log(u);

   this.userService.addUser(u).subscribe(result => console.log(result));
   console.log('wrote user');


  }
}
