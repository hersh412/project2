import { Injectable } from '@angular/core';
import { Router, NavigationStart } from '@angular/router';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlertService {
  private subject = new Subject<any>();
  private keepAfterNav = false;
 
  constructor(private router: Router) {
    router.events.subscribe(event => {
      if(event instanceof NavigationStart){
        if(this.keepAfterNav){
          this.keepAfterNav = false;
        } else {
          this.subject.next();
        }
      }

    });
   }
   success(message: string, keepAfterNav = false) {
    this.keepAfterNav = keepAfterNav;
    this.subject.next({ type: 'success', text: message });
  }

  error(message: string, keepAfterNav = false) {
      this.keepAfterNav = keepAfterNav;
      this.subject.next({ type: 'error', text: message });
  }

  getMsg(): Observable<any> {
      return this.subject.asObservable();
  }

}
