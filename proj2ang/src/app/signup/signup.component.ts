import {Component} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {Users} from '../model/user.model';
import {PasswordValidators} from './password.validators';
import {UsersService} from '../../services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  providers: [UsersService]
})
export class SignupComponent {

  sf = this.fb.group({
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
   const u: Users = new Users(this.sf.controls.email.value, this.sf.controls.password.value, 1,
                            this.sf.controls.firstname.value, this.sf.controls.lastname.value, this.sf.controls.address.value,
                            this.sf.controls.address2.value , this.sf.controls.city.value , this.sf.controls.state.value ,
                            this.sf.controls.zipcode.value , this.sf.controls.gender.value === 'Male');

   this.userService.addUser(u).subscribe(result => console.log(result));
  }
}
