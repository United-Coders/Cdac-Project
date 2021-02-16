import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { AdminserviceService , Admin , Message} from './../adminservice.service';
import { FormControl, Validators, FormGroup } from '@angular/forms'

@Component({
  selector: 'app-adminregister',
  templateUrl: './adminregister.component.html',
  styleUrls: ['./adminregister.component.css']
})
export class AdminregisterComponent implements OnInit {

  admin: Admin = new Admin( null ,null, null, null, null, null);

  public message: Message;
  public mssg: string = "";

  constructor(private adminserviceService : AdminserviceService) { }

  ngOnInit(): void {
  }

  public RegisterAdmin(obj: any) {
    this.adminserviceService.RegisterAdmin(obj).subscribe(res => {
      this.admin.firstName = "";
      this.admin.lastName = "";
      this.admin.email = "";
      this.admin.password = "";
      this.admin.phone = "";
      this.message = <Message>res;
      console.log(this.message.message);
      if (this.message.flag) {
        this.adminserviceService.LoginAdminPage();
      }
      else {
        this.mssg = this.message.message;
      }

    });
  }


  public LoginAdmin() {
    this.adminserviceService.LoginAdminPage();
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
