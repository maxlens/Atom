import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AtomAppComponent } from './atom-app.component';
import { AppRoutingModule } from './app-routing.module';
import { EndpointInterceptor } from './utilities/endpoint-interceptor';

import { DashboardComponent } from './components/dashboard/dashboard.component';

@NgModule({
  declarations: [
    AtomAppComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: EndpointInterceptor, multi: true}],
  bootstrap: [AtomAppComponent]
})
export class AppModule { }
