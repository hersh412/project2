import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Users } from '../app/model/user.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UsersService {
  url = '/WEB-INF/pages/users';
  loginUrl = '/login';

  constructor(private http: HttpClient) { }

  getUsers(): Observable<Users[]> {
    return this.http.get<Users[]>(this.url);
  }

  /*
  getUserById(id: string): Promise<Users>{
    return this.http.get<Users>(this.url+"/"+id).toPromise();
  }
  */

  getUser(userEmail: string, userPassword: string): Promise<Users> {
    return this.http.get<Users>(this.url + '/byemail/' + userEmail).toPromise();
  }


  addUser(user: Users): Observable<Users> {
    return this.http.post<Users>('http://localhost:8080/project2_war/user', user);
  }



  editUser(user: Users): Observable<Users> {
    return this.http.put<Users>(this.url, user);
  }
}
