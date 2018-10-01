import { Component } from '@angular/core';
import { AuthenticationService } from './services/authentication.service';
import { NgbModal, NgbModalOptions } from '@ng-bootstrap/ng-bootstrap';
import { Idle } from '@ng-idle/core';

@Component({
  selector: 'app-atom',
  templateUrl: './atom-app.component.html',
  styleUrls: ['./atom-app.component.css']
})
export class AtomAppComponent {
  title = 'Atom';
  isNavbarCollapsed = true;
  inactivityWarning = null;
  moddelOptions: NgbModalOptions = {};

  constructor(private authenticationService: AuthenticationService, private modelService: NgbModal, private idle: Idle) {

  }

  logout() {
    this.authenticationService.logout();
  }

  loggedIn() {
    return localStorage.getItem('currentUser');
  }

}
