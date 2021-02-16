import { Component, OnInit } from '@angular/core';
import { AdminserviceService , Admin , Message} from './../adminservice.service';
import { FormControl, Validators, FormGroup } from '@angular/forms'

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  admin: Admin = new Admin( null ,null, null, null, null, null);
  message: Message = new Message(null, null);
  
  public mssg: string = "";
  
  constructor(private adminserviceService : AdminserviceService) { }

  ngOnInit(): void {
  }

  public LoginValidate2(admin: Admin) {
    return this.adminserviceService.LoginValidate2(admin).subscribe(res => {
      this.message = <Message>res;
      if (this.message.flag) {
        console.log(this.message.message);
        sessionStorage.setItem('sid', 'true');
        this.adminserviceService.AdminHomePage();
      } else {
        this.mssg = this.message.message;
      }
    });
  }

  ngForm = new FormGroup({
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
      Validators.pattern('[a-zA-Z0-9@#%&+]+')      //^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).{6,12}$
    ]),
  
  });



}
