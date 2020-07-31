import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {AuthService} from '../authentication/auth.service';
import {AuthResponseModel} from '../shared/auth-response.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, AfterViewInit {
  @ViewChild('authForm') authForm: NgForm;
  isSignIn = false;
  isProcessing = false;
  error = null;

  constructor(private router: Router,
              private authService: AuthService) {
  }

  ngOnInit(): void {

  }

  ngAfterViewInit() {
  }

  onChanges() {
    this.error = null;
  }

  public submit() {
    this.isProcessing = true;
    if (!this.authForm.valid) {
      return;
    }
    const username = this.authForm.value.username;
    const password = this.authForm.value.password;

    let authen: Observable<any>;
    if (this.isSignIn) {
      console.log('Sign In:' + username + ', ' + password);
      authen = this.authService.signIn(username, password);
    } else {
      console.log('Sign Up:' + username + ', ' + password);
      authen = this.authService.signUp(username, password);
    }

    authen.subscribe(
      (responseData: AuthResponseModel<any>) => {
        console.log(responseData.error_code);
        this.isProcessing = false;
        if (responseData.error_code === 200) {
          this.router.navigate(['../forum']);
        } else {
          this.error = responseData.error_message;
        }
      },
      responseError => {
        console.log(responseError);
        this.error = responseError;
        this.isProcessing = false;
      }
    );
  }

  public switch() {
    this.isSignIn = !this.isSignIn;
  }
}
