import { Component, OnInit } from '@angular/core';
import { Admin, AdminserviceService, Message } from '../adminservice.service';

@Component({
  selector: 'app-adminforget',
  templateUrl: './adminforget.component.html',
  styleUrls: ['./adminforget.component.css']
})
export class AdminforgetComponent implements OnInit {
  admin: Admin = new Admin(null, null,null,null,null,null);
  public mssg: string = "";
  constructor(private adminserviceService:AdminserviceService) { }
  message: Message = new Message(null, null);
  ngOnInit(): void {
  }
  //<--! Code for forgot password for admin -->
  public getPasswordAdmin(admin:Admin){
    return this.adminserviceService.checkPasswordAdmin(admin).subscribe(res => {
      this.message = <Message>res;
      if (this.message.flag) {
        console.log(this.message.message);
      
        this.adminserviceService.LoginAdminPage();
      } else {
        this.mssg = this.message.message;
      }
    });
  }


}
