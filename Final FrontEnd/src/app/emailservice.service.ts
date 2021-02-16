import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';



export class Contact {
  constructor(
    
    public name: string,
    public phone: string,
    public email: string,
    public subject: string,
    public comment: string,
     ) { }
}


export class Contact1 {
  constructor(
    
    public name: string,
    public phone: string,
    public email: string,
    public subject: string,
    public comment: string,
    public attachment : string ) { }
}



@Injectable({
  providedIn: 'root'
})
export class EmailserviceService {

  constructor( private httpClient: HttpClient,
    private router: Router) { }

    public sendText(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/sendText", <Contact>obj);
    }

    public sendEmail(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/sendcontact", <Contact>obj);
    }

    public SendEmailAttachment(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/sendAttachmentEmail", <Contact1>obj);
    }

    public EndEmailPage() {
      return this.router.navigate(['emailhome']);
    }

   


}
