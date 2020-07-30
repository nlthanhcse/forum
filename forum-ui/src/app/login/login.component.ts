import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';

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

  constructor(private router: Router) {
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
      // authen = this.authService.signIn(email, password);
    } else {
      console.log('Sign Up:' + username + ', ' + password);
      // authen = this.authService.signUp(email, password);
    }

    setTimeout(() => {
      this.isProcessing = false;
    }, 1500);

    // authen.subscribe(
    //   responseData => {
    //     console.log(responseData);
    //     this.isProcessing = false;
    //     this.router.navigate(['../recipe']);
    //   },
    //   responseError => {
    //     console.log(responseError);
    //     this.error = responseError;
    //     this.isProcessing = false;
    //   }
    // );
  }

  public switch() {
    this.isSignIn = !this.isSignIn;
  }
}
