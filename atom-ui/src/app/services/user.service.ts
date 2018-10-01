import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  // baseUrl = '/api/v1/users';
  // baseUrl = '/cassandrausers';
  baseUrl = '/mongousers';

  constructor(private httpClient: HttpClient) { }

  getUsers() {
    return this.httpClient.get<User[]>(this.baseUrl);
  }

  getCassandraUsers(): Observable<Array<User>> {
    return this.httpClient.get(this.baseUrl)
    .pipe(map((data: any) => data._embedded.cassandrausers as User[]));
  }

  getMongoUsers(): Observable<Array<User>> {
    return this.httpClient.get(this.baseUrl)
    .pipe(map((data: any) => data._embedded.mongousers as User[]));
  }
}
