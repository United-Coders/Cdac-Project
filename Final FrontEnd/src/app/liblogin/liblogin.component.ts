import { Component, OnInit } from '@angular/core';
import { LibrarianserviceService , Librarian , Message} from './../librarianservice.service';

@Component({
  selector: 'app-liblogin',
  templateUrl: './liblogin.component.html',
  styleUrls: ['./liblogin.component.css']
})
export class LibloginComponent implements OnInit {


  librarian: Librarian = new Librarian( null,null ,null, null, null, null, null);
  message: Message = new Message(null, null);
  
  public mssg: string = "";
  constructor(private librarianserviceService : LibrarianserviceService ) { }

  ngOnInit(): void {
  }

  public LoginValidate1(librarian: Librarian) {
    return this.librarianserviceService.LoginValidate1(librarian).subscribe(res => {
      this.message = <Message>res;
      if (this.message.flag) {
        console.log(this.message.message);
        sessionStorage.setItem('sid', 'true');
        this.librarianserviceService.LibrarianHomePage();
      } else {
        this.mssg = this.message.message;
      }
    });
  }

}
