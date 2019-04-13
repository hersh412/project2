import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

import { AuthenticationService } from 'src/services/authentication.service';

@Injectable()
export class HttperrorInterceptor implements HttpInterceptor {
    constructor(
        private authenticationService: AuthenticationService
    ) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let loggedinUser = this.authenticationService.loggedinUserValue;
        if (loggedinUser && loggedinUser.token){
            request = request.clone({
                setHeaders: {
                    Authorization: 'Bearer ${currentUser.token}'
                }
            });
        }

        return next.handle(request);
    }
}
