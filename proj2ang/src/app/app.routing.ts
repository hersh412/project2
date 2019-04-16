import { Routes, RouterModule } from '@angular/router';

import { NavbarComponent } from '../app/navbar/navbar.component';

import { AuthorizationGuard } from '../app/guards/authorization.guard';
import { QuoteComponent } from './quote/quote.component';

const appRoutes: Routes = [
    { path: '', component: NavbarComponent },
    { path: '/quote', component: QuoteComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
