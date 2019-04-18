import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpEvent } from '@angular/common/http';
import { User } from '../app/model/user.model';
import { Observable } from 'rxjs';


@Injectable({
 providedIn: 'root'
})
export class UsersService {
 url = '/users';
 loginUrl = '/logins';

 constructor(private http: HttpClient) { }

 getUsers(): Observable<User[]> {
   return this.http.get<User[]>(this.url);
 }

 /*
 getUserById(id: string): Promise<Users>{
   return this.http.get<Users>(this.url+"/"+id).toPromise();
 }
 */

 getUser(userEmail: string, userPassword: string): Promise<User> {
   return this.http.get<User>(this.url + '/byemail/' + userEmail).toPromise();
 }

  /*
 loginValid(id: number): Promise<Users>{
   return this.http.get<Users>(this.loginUrl).toPromise();
 }
 */

 editUser(user: User): Observable<User> {
   return this.http.put<User>(this.url, user);
 }
}
