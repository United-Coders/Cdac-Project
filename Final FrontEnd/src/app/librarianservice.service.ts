import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';


export class Message {
  constructor(
    public message: string,
    public flag: boolean
  ) { }
}

export class Librarian {
  constructor(
    public lib_id: number,
    public name: string,
    public phone: string,
    public email: string,
    public password: string,
    public licence_no: string,
    public address: string) { }
}




@Injectable({
  providedIn: 'root'
})
export class LibrarianserviceService {

  constructor( private httpClient: HttpClient,
    private router: Router) { }

    private baseURL2 = "http://localhost:8080/deleteLibrarian";


    public RegisterLibrarian(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/registerLibrarian", <Librarian>obj);
    }
  
    public LoginValidate1(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/LibrarianValidate", <Librarian>obj);
    }

    public RegisterLibrarianPage() {
      return this.router.navigate(['libregister']);
    }
    public LibrarianHomePage() {
      return this.router.navigate(['librarianhome']);
    }

    public LoginLibrarianPage() {
      return this.router.navigate(['liblogin']);
    }


    getLibList():Observable<Librarian[]> {
      return this.httpClient.get<Librarian[]>("http://localhost:8080/Librarydisplay");
    }

    deleteLib(id: number): Observable<object> {
     return this.httpClient.delete(`${this.baseURL2}/${id}`);

    }


    public checkPasswordLib(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/getLibPass", <Librarian>obj);
    }

    public LoginLibPage() {
      return this.router.navigate(['liblogin']);
    }


}
