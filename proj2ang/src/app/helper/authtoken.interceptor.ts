import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

import { AuthenticationService } from 'src/services/authentication.service';

@Injectable()
export class AuthTokenInterceptor implements HttpInterceptor {
    constructor(
        private authenticationService: AuthenticationService
    ) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let loggedinUser = this.authenticationService.loggedinUserValue;
        if (loggedinUser && loggedinUser.token){
            request = request.clone({
                setHeaders: {
                    'Access-Control-Allow-Origin': 'http://localhost:4200', // -->Add this line
                    'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,OPTIONS',
                    'Access-Control-Allow-Headers': '*',
                    'Content-Type': 'application/json',
                    Accept: 'application/json',
                    Authorization: 'Bearer ${currentUser.token}'
                }
            });
        }

        return next.handle(request);
    }
}
