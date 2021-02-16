import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-librarianprofile',
  templateUrl: './librarianprofile.component.html',
  styleUrls: ['./librarianprofile.component.css']
})
export class LibrarianprofileComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
    if(!sessionStorage.getItem("sid")){
      this.router.navigate(["liblogin"]);
    }
  }

}
