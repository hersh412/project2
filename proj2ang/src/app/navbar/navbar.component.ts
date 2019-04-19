import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UsersService} from '../../services/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from 'src/services/authentication.service';
import {AlertService} from 'src/services/alert.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  loginForm: FormGroup;
  submitted = false;
  loading = false;
  returnUrl: string;
  notLoggedin = true;

  constructor(private formBuilder: FormBuilder,
              private usersService: UsersService,
              private route: ActivatedRoute,
              private router: Router,
              private authenticationService: AuthenticationService,
              private alertService: AlertService
    ) {
      if (this.authenticationService.loggedinUserValue) { 
        this.notLoggedin = false;
        this.router.navigate(['/']);
    }
     }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
   });
   this.returnUrl = this.route.snapshot.queryParams.returnUrl || 'customerHome';
  }

  get fc() {return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;
   

    if (this.loginForm.invalid){
      return;
    }

    this.loading = true;

      /* The first() operator takes an optional predicate function and emits an error notification 
      when no value matched when the source completed.
      */
    this.authenticationService.login(this.fc.email.value, this.fc.password.value)
    .pipe(first())
            .subscribe(
                data => {
                  this.loading = false;
                  this.notLoggedin = false;
                  console.log("just before navigate");
                  //this.router.navigate(['/customerHome']);
                  this.router.navigate(['/customer']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });

  }
}
