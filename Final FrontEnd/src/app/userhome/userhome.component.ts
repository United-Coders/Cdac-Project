import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { faStar,faStarHalfAlt } from '@fortawesome/free-solid-svg-icons'


@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {
  public faStar = faStar;
  public faStarHalfAlt = faStarHalfAlt;
  constructor(private router: Router) { }

  ngOnInit(): void {
    if (!sessionStorage.getItem('sid')) {
      this.router.navigate(['login']);
    }
  }

}
