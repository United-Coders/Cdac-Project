import { Router } from '@angular/router';
import { BooksService } from './../books.service';
import { Books } from './../books';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-books',
  templateUrl: './add-books.component.html',
  styleUrls: ['./add-books.component.css']
})
export class AddBooksComponent implements OnInit {

  bookss: Books = new Books();
  constructor(private booksService: BooksService, private router: Router) { }

  ngOnInit(): void {

    if(!sessionStorage.getItem("sid")){
      this.router.navigate(["liblogin"]);
    }
  }

  saveBook() {
    this.booksService.addBooks(this.bookss).subscribe(data => {
      console.log(data);
      this.gotoBookList();
    },
      error => console.log(error));
  }

  gotoBookList() {
    this.router.navigate(['booklist']);
  }

  onSubmit() {

    console.log(this.bookss);
    this.saveBook();
  }

}
