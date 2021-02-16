import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';


export class Message {
  constructor(
    public message: string,
    public flag: boolean
  ) { }
}


export class Admin {
  constructor(
    public admin_id: number,
    public firstName: string,
    public phone: string,
    public email: string,
    public password: string,
    public lastName: string,
    ) { }
}











@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  constructor(private httpClient: HttpClient,
    private router: Router) { }


    public RegisterAdmin(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/registerAdmin", <Admin>obj);
    }
  
    public LoginValidate2(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/AdminValidate", <Admin>obj);
    }


    public RegisterAdminPage() {
      return this.router.navigate(['adminregister']);
    }
    public AdminHomePage() {
      return this.router.navigate(['adminhome']);
    }

    public LoginAdminPage() {
      return this.router.navigate(['adminlogin']);
    }


     public checkPasswordAdmin(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/getAdminPass", <Admin>obj);
      }
      
     
}
