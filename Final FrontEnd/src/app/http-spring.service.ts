import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Status } from './appmodel/status';

export class Message {
  constructor(
    public message: string,
    public flag: boolean
  ) { }
}

export class User {
  constructor(
    public userId: number,
    public firstname: string,
    public contact: string,
    public email: string,
    public password: string,
    public lastname: string,
    public profilePic: string) { }
}



@Injectable({
  providedIn: 'root'
})
export class HttpSpringService {

  constructor( private httpClient: HttpClient,
    private router: Router) { }

    private baseURL2 = "http://localhost:8080/deleteUser";

    public signupSuccess(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/registerUser1", <User>obj);
    }


    public RegisterUser(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/registerUser", <User>obj);
    }
  
    public LoginValidate(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/UserValidate", <User>obj);
    }
  
    public RegisterUserPage() {
      return this.router.navigate(['registration']);
    }
    public UserHomePage() {
      return this.router.navigate(['userhomelist']);
    }

    public LoginUserPage() {
      return this.router.navigate(['login']);
    }
  
    public displayList() {
      return this.httpClient.get<User[]>("http://localhost:8080/display");
    }
  
    public deleteUserService(user: User) {
      return this.httpClient.delete<User>(`http://localhost:8080/deleteUser/${user.userId}`);
    }

    public upload(formData: FormData) : Observable<Status> {
      let url = 'http://localhost:8080/pic-upload';
      return this.httpClient.post<Status>(url, formData);
    }
  
    public fetch(userId: number) : Observable<User> {
      let url = 'http://localhost:8080/profile?userId='+userId;
      return this.httpClient.get<User>(url);
    }

    public checkPassword(obj: any){
      return this.httpClient.post<any>("http://localhost:8080/getUserPass", <User>obj);
    }

    public ProfilePage() {
      return this.router.navigate(['userprofile']);
    }


    getUsersList():Observable<User[]> {
      return this.httpClient.get<User[]>("http://localhost:8080/display");
    }

    deleteUsers(id: number): Observable<object> {
     return this.httpClient.delete(`${this.baseURL2}/${id}`);

    }
}
