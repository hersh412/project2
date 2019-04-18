import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { QuoteComponent } from './quote/quote.component';
import { HomePageComponent } from './home-page/home-page.component';
import { QuoteFormComponent } from './quote/quote-form/quote-form.component';
import { SignupComponent } from './signup/signup.component';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import {AuthService} from './auth.service';
import { CustomerComponent } from './customer/customer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    QuoteComponent,
    HomePageComponent,
    QuoteFormComponent,
    SignupComponent,
    AddVehicleComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        path: '',
        component: HomePageComponent
      },
      {
        path: 'quote',
        component: QuoteComponent
      },
      {
        path: 'signup',
        component: SignupComponent
      },
      {
        path: 'addvehicle',
        component: AddVehicleComponent
      },
      {
        path: 'customer',
        component: CustomerComponent
      }
    ])
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
