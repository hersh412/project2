import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AlertComponent } from './components/alert/alert.component';
import { routing } from './app.routing';

import { HttperrorInterceptor } from './helper/httperror.interceptor';
import { AuthTokenInterceptor } from './helper/authtoken.interceptor';
import { HomePageComponent } from './home-page/home-page.component';
import { SignupComponent } from './signup/signup.component';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AlertComponent,
    HomePageComponent,
    SignupComponent,
    AddVehicleComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    routing
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthTokenInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: HttperrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
