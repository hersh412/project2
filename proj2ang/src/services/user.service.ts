import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpEvent, HttpErrorResponse} from '@angular/common/http';
import {User} from '../app/model/user.model';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import { throwError} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UsersService {
  url = '/users';
  loginUrl = '/logins';

  constructor(private http: HttpClient) {
  }

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

  addUser(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8080/project2_war/user', user).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  }
}
