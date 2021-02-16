import { Component, OnInit } from '@angular/core';
import { EmailserviceService, Contact1, } from './../emailservice.service';

import { Observable } from 'rxjs';

@Component({
  selector: 'app-emailattachment',
  templateUrl: './emailattachment.component.html',
  styleUrls: ['./emailattachment.component.css']
})
export class EmailattachmentComponent implements OnInit {

  contact1: Contact1 = new Contact1( null,null ,null, null, null, null);
  constructor(private emailServiceService: EmailserviceService) { }

  ngOnInit(): void {
  }

  public SendEmailAttachment(obj: any) {
    this.emailServiceService.sendText(obj).subscribe(res => {
      this.contact1.name = "";
      this.contact1.phone = "";
      this.contact1.email = "";
      this.contact1.subject = "";
      this.contact1.comment = "";
      this.contact1.attachment = "";
     
  
      
        this.emailServiceService.EndEmailPage();
     

    });
  }

  public EndEmail() {
    this.emailServiceService.EndEmailPage();
  }
}
