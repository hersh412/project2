import {RouterModule, Routes} from '@angular/router';

import {AuthorizationGuard} from '../app/guards/authorization.guard';

import {QuoteComponent} from './quote/quote.component';

import {AddVehicleComponent} from './add-vehicle/add-vehicle.component';

import {SignupComponent} from './signup/signup.component';

import {CustomerHomeComponent} from 'src/app/components/customer-home/customer-home.component';

import {HomePageComponent} from './home-page/home-page.component';

const appRoutes: Routes = [
    { path: '', component: HomePageComponent},
    { path: 'quote', component: QuoteComponent},
    { path: 'signup', component: SignupComponent},
    { path: 'addvehicle', component: AddVehicleComponent},
  {path: 'customer', component: CustomerHomeComponent, canActivate: [AuthorizationGuard]},

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
