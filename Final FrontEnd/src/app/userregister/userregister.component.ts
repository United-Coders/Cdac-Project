
import { Component, OnInit } from '@angular/core';
import { HttpSpringService, User, Message } from './../http-spring.service';
import { faNewspaper } from '@fortawesome/free-solid-svg-icons';
import { Observable } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormControl, Validators, FormGroup } from '@angular/forms'


@Component({
  selector: 'app-userregister',
  templateUrl: './userregister.component.html',
  styleUrls: ['./userregister.component.css'],
})
export class UserregisterComponent implements OnInit {
  user: User = new User( null ,null, null, null, null, null,null);
  public isStateSelected = false;
  public uiInvalidCredential = false;
  private faNewspaper = faNewspaper
  public message: Message;
  public mssg: string = "";
  
  constructor(private httpSpringService: HttpSpringService,private modalService: NgbModal) { }

  ngOnInit(): void {
  }

 

  public RegisterUser1(obj: any) {
    this.httpSpringService.RegisterUser(obj).subscribe(res => {
      this.user.firstname = "";
      this.user.lastname = "";
      this.user.email = "";
      this.user.password = "";
      this.user.contact = "";
      this.user.profilePic= "";
      this.message = <Message>res;
      console.log(this.message.message);
      // if (this.message.flag) {
      //   sessionStorage.setItem('userId', res.registeredUserId);
      //   this.httpSpringService.LoginUserPage();
      // }
      // else {
       // this.mssg = this.message.message;
      // }
      this.httpSpringService.signupSuccess(User);
      sessionStorage.setItem('userId', res.registeredUserId);
        this.httpSpringService.LoginUserPage();

    });
  }

  public LoginUser() {
    this.httpSpringService.LoginUserPage();
  }


  ngForm = new FormGroup({
    emailid: new FormControl('', [
      Validators.required,
      Validators.minLength(6),
      Validators.maxLength(50),
      Validators.pattern("[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$")
    ]),
    firstname: new FormControl('', [
      Validators.required,
      Validators.minLength(1),
      Validators.maxLength(20),
      Validators.pattern("[a-zA-Z]{1,20}")
    ]),
    lastname: new FormControl('', [
      Validators.required,
      Validators.minLength(1),
      Validators.maxLength(20),
      Validators.pattern("[a-zA-Z]{1,20}")
    ]),
   
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(6),
      Validators.maxLength(15),
      Validators.pattern('[a-zA-Z0-9@#%&+]+')      //^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).{6,12}$
    ]),
    phone: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(15),
      Validators.pattern("[0-9]{8,15}")
    ]),
  });




}

  


