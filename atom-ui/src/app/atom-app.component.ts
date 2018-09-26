import { Component } from '@angular/core';

@Component({
  selector: 'app-atom',
  templateUrl: './atom-app.component.html',
  styleUrls: ['./atom-app.component.css']
})
export class AtomAppComponent {
  title = 'Atom';
  isNavbarCollapsed = true;
}
