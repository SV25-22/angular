import { Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { AdminUsersComponent } from './admin-users/admin-users.component';

export const routes: Routes = [
    {path: "",redirectTo:"/login",pathMatch:'full'},
    {path: "admin",component: AdminComponent},
    {path: "login",component:LoginComponent},
    {path:"admin/users",component: AdminUsersComponent}
    //path not found component
];
