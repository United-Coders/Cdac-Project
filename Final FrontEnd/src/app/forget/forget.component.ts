import { Component, OnInit } from '@angular/core';
import { HttpSpringService, User, Message } from './../http-spring.service';

@Component({
  selector: 'app-forget',
  templateUrl: './forget.component.html',
  styleUrls: ['./forget.component.css']
})
export class ForgetComponent implements OnInit {
  
  public mssg: string = "";
  message: Message = new Message(null, null);
  user: User = new User(null, null, null, null, null, null,null);
  constructor( private httpSpringService: HttpSpringService) { }

  ngOnInit(): void {
  }

  public getPassword(user:User){
    return this.httpSpringService.checkPassword(user).subscribe(res => {
      this.message = <Message>res;
      if (this.message.flag) {
        console.log(this.message.message);
      
        this.httpSpringService.LoginUserPage();
      } else {
        this.mssg = this.message.message;
      }
    });
  }

}