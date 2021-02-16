import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LogoutModalComponent } from '../logout-modal/logout-modal.component';

@Component({
  selector: 'app-librarianheader',
  templateUrl: './librarianheader.component.html',
  styleUrls: ['./librarianheader.component.css']
})
export class LibrarianheaderComponent implements OnInit {

  constructor( private modelService: NgbModal , private router:Router) { }

  ngOnInit(): void {
    if(!sessionStorage.getItem("sid")){
      this.router.navigate(["liblogin"]);
    }
  }
  processLogout(){
    this.modelService.open(LogoutModalComponent, {
      centered: true,
    });
    
  }
}
