import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Users } from 'src/app/model/user.model';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private loggedinUserSubject: BehaviorSubject<Users>;
  public loggedinUser: Observable<Users>;
  
  constructor(private http: HttpClient) {
    this.loggedinUserSubject = new BehaviorSubject<Users>(JSON.parse(localStorage.getItem('loggedinUser')));
    this.loggedinUser = this.loggedinUserSubject.asObservable();
   }
   public get loggedinUserValue(): Users {
     return this.loggedinUserSubject.value;
   }

   login(email: string, password: string) {
    //return this.http.post<any>(`${config.apiUrl}/login`, { email, password }) <--use this!!! http://localhost:8080
    return this.http.post<any>(`http://localhost:8080/login`, { email, password })  
    .pipe(map(user => {

        if (user && user.token) {
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.loggedinUserSubject.next(user);
        }

        return user;
     }));
  }

  logout() {
    localStorage.removeItem('currentUser');
    this.loggedinUserSubject.next(null);
  }
}
