import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { first } from 'rxjs/operators';


import { UsersService} from 'src/services/user.service';
import { AuthenticationService} from 'src/services/authentication.service';
import { Users } from 'src/app/model/user.model';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit, OnDestroy {
  loggedinUser: Users;
  loggedinUserSubscription: Subscription;
  
  constructor(
    private authenticationService: AuthenticationService,
    private userService: UsersService
  ) {
    this.loggedinUserSubscription = this.authenticationService.loggedinUser.subscribe(user => {
      this.loggedinUser = user;
   });
  }

  ngOnInit() {
  }

  ngOnDestroy(){
    this.loggedinUserSubscription.unsubscribe();
  }

}
