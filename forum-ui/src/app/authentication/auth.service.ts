import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthResponseModel} from '../shared/auth-response.model';
import {BehaviorSubject} from 'rxjs';
import {UserModel} from '../shared/user.model';
import {tap} from 'rxjs/operators';

@Injectable()
export class AuthService {
  constructor(private http: HttpClient) {
  }

  public signUp(username: string, password: string) {

    return this.http
      .post<AuthResponseModel<any>>(
        'http://localhost:8087/api/auth/sign-up',
        {
          username,
          password
        }
      );
  }

  public signIn(username: string, password: string) {
    return this.http
      .post<AuthResponseModel<any>>(
        'http://localhost:8087/api/auth/sign-in',
        {
          username,
          password
        }
      );
  }

  public signOut() {
    return this.http
      .get<AuthResponseModel<any>>(
        'http://localhost:8087/api/auth/sign-out',
      );
  }
}
