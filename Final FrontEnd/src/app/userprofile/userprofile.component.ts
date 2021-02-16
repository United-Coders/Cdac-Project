import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../http-spring.service';

import { HttpSpringService } from '../http-spring.service';


@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {

  user : User;

  constructor(private service: HttpSpringService, private router:Router) { }
  ngOnInit(): void {

    if(!sessionStorage.getItem("sid")){
      this.router.navigate(["login"]);
    }
    let userId = parseInt(sessionStorage.getItem('userId'));
    this.service.fetch(userId).subscribe(user => {
      this.user = user;
    })
  
  }

  // onSubmit() {
  //   this.httpSpringService.updateBook(this.id, this.books).subscribe( data => {
  //     this.goToBookList();
  //   }
  //   , error => console.log(error));
  // }

}
