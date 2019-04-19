import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AlertComponent} from './components/alert/alert.component';
import {routing} from './app.routing';

import {HttperrorInterceptor} from './helper/httperror.interceptor';
import {AuthTokenInterceptor} from './helper/authtoken.interceptor';
import {HomePageComponent} from './home-page/home-page.component';
import {SignupComponent} from './signup/signup.component';
import {AddVehicleComponent} from './add-vehicle/add-vehicle.component';
import {QuoteFormComponent} from './quote/quote-form/quote-form.component';
import {QuoteComponent} from './quote/quote.component';
import {CustomerHomeComponent} from './components/customer-home/customer-home.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {TabsetBasicComponent} from './components/customer-home/tabset-basic/tabset-basic.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AlertComponent,
    HomePageComponent,
    SignupComponent,
    AddVehicleComponent,
    QuoteFormComponent,
    SignupComponent,
    CustomerHomeComponent,
    QuoteComponent,
    TabsetBasicComponent

  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    routing,
    NgbModule

  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthTokenInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: HttperrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
