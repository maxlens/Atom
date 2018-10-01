import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getMongoUsers();
  }

  getUsers() {
    this.userService.getUsers().subscribe((data: Array<User>) => {
      this.users = data;
    });
  }

  getCassandraUsers() {
    this.userService.getCassandraUsers().subscribe((data: Array<User>) => {
      this.users = data;
    });
  }

  getMongoUsers() {
    this.userService.getMongoUsers().subscribe((data: Array<User>) => {
      this.users = data;
    });
  }

}
