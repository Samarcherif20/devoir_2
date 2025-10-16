import { Routes } from '@angular/router';
import { MakeupComponent } from './makeup/makeup.component';
import { canActivateAuthRole } from './guards/auth-role.guard';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

export const routes: Routes = [

    {path: "makeup", 
    component : MakeupComponent, 
    canActivate: [canActivateAuthRole],    
    data: { role: 'ADMIN' }
    },
     { path: 'profile', component: UserProfileComponent },
    { path: 'forbidden', component: ForbiddenComponent }

];
