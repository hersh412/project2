import { Routes, RouterModule } from '@angular/router';

import { NavbarComponent } from '../app/navbar/navbar.component';

import { AuthorizationGuard } from '../app/guards/authorization.guard';

const appRoutes: Routes = [
    { path: '', component: NavbarComponent},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
