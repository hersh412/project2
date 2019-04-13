import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';

import { AlertService } from 'src/services/authentication.service';
@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  msg: any;
  
  constructor(private alertService: AlertService) { }

  ngOnInit() {
    this.subscription = this.alertService.getMsg().subscribe(msg => {
      this.msg = msg;
    })
    
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
