import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgIdleKeepaliveModule } from '@ng-idle/keepalive';

import { AtomAppComponent } from './atom-app.component';
import { AppRoutingModule } from './app-routing.module';
import { EndpointInterceptor } from './helpers/endpoint-interceptor';

import { DashboardComponent } from './components/dashboard/dashboard.component';
import { JwtInterceptor } from './helpers/jwt.interceptor';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    AtomAppComponent,
    DashboardComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    NgIdleKeepaliveModule.forRoot(),
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: EndpointInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
  ],
  bootstrap: [AtomAppComponent]
})
export class AppModule { }
