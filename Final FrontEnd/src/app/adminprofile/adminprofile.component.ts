import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminprofile',
  templateUrl: './adminprofile.component.html',
  styleUrls: ['./adminprofile.component.css']
})
export class AdminprofileComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
    if (!sessionStorage.getItem('sid')) {
      this.router.navigate(['adminlogin']);
    }
  }

}
