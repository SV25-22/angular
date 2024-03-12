import { Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { AdminUsersComponent } from './admin-users/admin-users.component';
import { AddTemplateComponent } from './add-template/add-template.component';
import { AllTemplatesComponent } from './all-templates/all-templates.component';

export const routes: Routes = [
    {path: "",redirectTo:"/login",pathMatch:'full'},
    {path: "admin",component: AdminComponent},
    {path: "login",component:LoginComponent},
    {path:"admin/users",component: AdminUsersComponent},
    {path: "admin/addTemplate",component: AddTemplateComponent},
    {path: "admin/allTemplates",component: AllTemplatesComponent}

];
