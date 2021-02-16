import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Librarian, LibrarianserviceService } from '../librarianservice.service';

@Component({
  selector: 'app-liblist',
  templateUrl: './liblist.component.html',
  styleUrls: ['./liblist.component.css']
})
export class LiblistComponent implements OnInit {
  librarian: Librarian[];

  constructor(private libService: LibrarianserviceService,
    private router: Router) { }

  ngOnInit(): void {
    if (!sessionStorage.getItem('sid')) {
      this.router.navigate(['adminlogin']);
    }
    this.getlib();
  }

  private getlib() {
    this.libService.getLibList().subscribe(data => {
      this.librarian = data;
      console.log(this.librarian);
    });

  }

 
  deleteLib(id: number) {
    this.libService.deleteLib(id).subscribe(data => {
      console.log(data);
      this.getlib();
    })
  }
 
}
