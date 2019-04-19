import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Users} from '../app/model/user.model';
import {subscribeTo} from 'rxjs/internal-compatibility';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {

  constructor(private http: HttpClient) { }

createPolicy() {
    let userid: Number;
    let currentUser: Users = JSON.parse(localStorage.getItem('loggedinUser'));
    const currentUserID = currentUser.id;

    this.http.post('http://localhost:8080/user/' + currentUserID + '/policy', '')
    .subscribe(response => {
    localStorage.setItem('policyID',  JSON.stringify(response));
  });

}
}
