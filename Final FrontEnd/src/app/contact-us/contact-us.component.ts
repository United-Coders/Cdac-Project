import { Component, OnInit } from '@angular/core';
import { EmailserviceService, Contact, } from './../emailservice.service';

import { Observable } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  contact: Contact = new Contact( null ,null, null, null, null);

  constructor(private emailServiceService: EmailserviceService, private router: Router) { }

  ngOnInit(): void {
  }

  public sendEmail(obj: any) {
    this.emailServiceService.sendEmail(obj).subscribe(res => {
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

  public EndEmailPage(){
    this.router.navigate(['home']);
  }

}
