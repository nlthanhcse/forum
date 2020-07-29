import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {HomeComponent} from './home/home.component';


const routes: Routes = [
  // {path: '', component: LoginComponent, pathMatch: 'full'}, // pathMatch: 'full' means only redirect when the url is fully empty
  {path: 'forum', component: HomeComponent},
  {path: 'login', component: LoginComponent}
  // {path: '**', redirectTo: '/recipe'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
