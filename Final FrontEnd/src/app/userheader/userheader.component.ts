import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LogoutModalComponent } from '../logout-modal/logout-modal.component';

@Component({
  selector: 'app-userheader',
  templateUrl: './userheader.component.html',
  styleUrls: ['./userheader.component.css']
})
export class UserheaderComponent implements OnInit {

  constructor( private modelService: NgbModal , private router:Router) { }

  ngOnInit(): void {
  }
  processLogout(){
    this.modelService.open(LogoutModalComponent, {
      centered: true,
    });
    
  }
}
