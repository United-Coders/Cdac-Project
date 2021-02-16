import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-librarianhome',
  templateUrl: './librarianhome.component.html',
  styleUrls: ['./librarianhome.component.css']
})
export class LibrarianhomeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    if (!sessionStorage.getItem('sid')) {
      this.router.navigate(['liblogin']);
    }
  }

}
