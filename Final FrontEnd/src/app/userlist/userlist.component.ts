import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { HttpSpringService, User } from '../http-spring.service';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {

 
  users: User[];

  constructor(private usersService: HttpSpringService,
    private router: Router) { }

  ngOnInit(): void {

    if (!sessionStorage.getItem('sid')) {
      this.router.navigate(['adminlogin']);
    }
    this.getUsers();
  }

  private getUsers() {
    this.usersService.getUsersList().subscribe(data => {
      this.users = data;
      console.log(this.users);
    });

  }

 
  deleteUsers(id: number) {
    this.usersService.deleteUsers(id).subscribe(data => {
      console.log(data);
      this.getUsers();
    })
  }
 
}
