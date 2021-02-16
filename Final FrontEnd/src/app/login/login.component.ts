import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpSpringService, User, Message } from './../http-spring.service';
import { FormControl, Validators, FormGroup } from '@angular/forms'
import { Status } from '../appmodel/status';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public uiInvalidCredential = false;
  public mssg: string = "";
  message: Message = new Message(null, null);
  user: User = new User(null, null, null, null, null, null,null);

  constructor( private httpSpringService: HttpSpringService,private router: Router) { }

  ngOnInit(): void {
    
  }

  public LoginValidate(user: User) {
    return this.httpSpringService.LoginValidate(user).subscribe(res => {
      this.message = <Message>res;
     // this.message = <Status>res;
      this.user = <User>res;
  //     //if (this.message.flag) {
  //       //console.log(this.message.message);
       
  //    // } else {
  //      this.mssg = this.message.message;
  //  //}
      console.log(this.message.message);
      sessionStorage.setItem('sid', 'true');
      sessionStorage.setItem('userId', res.userId);
      this.httpSpringService.UserHomePage();
    });
  }




  myFormGroup = new FormGroup({
    emailid: new FormControl('', [
      Validators.required,
      Validators.minLength(6),
      Validators.maxLength(50),
      Validators.pattern("[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$")
    ]),
   
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(6),
      Validators.maxLength(15),
      Validators.pattern('[a-zA-Z0-9@#%&+]+')         //^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).{6,12}$
    ]),
   
  });


}
