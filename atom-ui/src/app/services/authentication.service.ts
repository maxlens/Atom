import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Idle } from '@ng-idle/core';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    constructor(private http: HttpClient, private idle: Idle) { }

    login(username: string, password: string) {
        return this.http.post<any>('/auth', { username, password })
            .pipe(map((res: any) => {
                // store username and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('currentUser', JSON.stringify({username, token: res.token}));
                console.log(localStorage.getItem('currentUser'));
            }));
    }

    logout() {
        // remove user from local storage
        localStorage.removeItem('currentUser');
        this.idle.stop();
    }
}
