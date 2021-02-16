import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-logout-modal',
  templateUrl: './logout-modal.component.html',
  styleUrls: ['./logout-modal.component.css']
})
export class LogoutModalComponent implements OnInit {

  constructor( private router: Router,public activeModal:NgbActiveModal) { }

  ngOnInit(): void {
  }
  closeTheModal() {
    this.activeModal.dismiss();
  }

  logOutAndClose() {
    sessionStorage.removeItem('sid');
    sessionStorage.removeItem('userId');

   // dismiss the modal
   this.activeModal.dismiss();

    this.router.navigate(['home']);
  }
}
