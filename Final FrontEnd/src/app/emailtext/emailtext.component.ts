import { Component, OnInit } from '@angular/core';
import { EmailserviceService, Contact, } from './../emailservice.service';

import { Observable } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-emailtext',
  templateUrl: './emailtext.component.html',
  styleUrls: ['./emailtext.component.css']
})
export class EmailtextComponent implements OnInit {
  contact: Contact = new Contact( null ,null, null, null, null);
  constructor(private emailServiceService: EmailserviceService,private router: Router) { }

  ngOnInit(): void {
    if(!sessionStorage.getItem("sid")){
      this.router.navigate(["liblogin"]);
    }
  }


  public sendText(obj: any) {
    this.emailServiceService.sendText(obj).subscribe(res => {
      this.contact.name = "";
      this.contact.phone = "";
      this.contact.email = "";
      this.contact.subject = "";
      this.contact.comment = "";
     
  
      if (true) {
        this.emailServiceService.EndEmailPage();
      }
      else {
       
      }

    });
  }

  public EndEmail() {
    this.router.navigate["libhome"];
  }

}
