 import { Injectable } from '@angular/core';
 import {HttpClient} from '@angular/common/http';
 import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials) {
    return this.http.post('http://localhost:8080/project2/users/validate', credentials);
  }

  logout() {}

  isLoggedIn() {
    return false;
  }
}
