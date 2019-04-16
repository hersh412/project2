import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthenticationService } from 'src/services/authentication.service';

@Injectable()
export class HttperrorInterceptor implements HttpInterceptor {
    constructor(
        private authenticationService: AuthenticationService
    ){}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => {
            if(err.status === 401){
                this.authenticationService.logout(); // Logging out unauthorized user
                location.reload(true);
                return throwError(new Error('ACCESS DENIED!'))
            }
            const retMessage = err.error.message || err.statusText;
            return throwError(retMessage);
        }));
    }


}