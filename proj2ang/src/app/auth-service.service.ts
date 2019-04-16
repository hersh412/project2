 import { Injectable } from '@angular/core';
 import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http: HttpClient) { }

  login(credentials) {
    return this.http.post('project2/')
  }
}
