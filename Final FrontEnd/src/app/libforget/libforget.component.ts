import { Component, OnInit } from '@angular/core';
import { HttpSpringService } from '../http-spring.service';
import { Librarian, LibrarianserviceService, Message } from '../librarianservice.service';

@Component({
  selector: 'app-libforget',
  templateUrl: './libforget.component.html',
  styleUrls: ['./libforget.component.css']
})
export class LibforgetComponent implements OnInit {

  public mssg: string = "";
  message: Message = new Message(null, null);
  librarian : Librarian = new Librarian(null, null,null,null,null,null,null);
  constructor( private librarianserviceService: LibrarianserviceService) { }


  ngOnInit(): void {
  }

  //<--! Code for forgot password for librarian -->
public getPasswordLibrarian(librarian:Librarian){
  return this.librarianserviceService.checkPasswordLib(librarian).subscribe(res => {
    this.message = <Message>res;
    if (this.message.flag) {
      console.log(this.message.message);
    
      this.librarianserviceService.LoginLibPage();
    } else {
      this.mssg = this.message.message;
    }
  });
}

}
