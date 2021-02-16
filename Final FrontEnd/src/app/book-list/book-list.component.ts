import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BooksService } from './../books.service';
import { Books } from './../books';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Books[];

  constructor(private booksService: BooksService,
    private router: Router) { }

  ngOnInit(): void {
    if(!sessionStorage.getItem("sid")){
      this.router.navigate(["liblogin"]);
    }
    this.getBooks();
  }

  private getBooks() {
    this.booksService.getBooksList().subscribe(data => {
      this.books = data;
    });
  }

  booksDetails(id: number){
    
    this.router.navigate(['books-details', id]);
  }


  deleteBooks(id: number) {
    this.booksService.deleteBooks(id).subscribe(data => {
      console.log(data);
      this.getBooks();
    })
  }

  updateBooks(id: number) {
    this.router.navigate(['update-books', id]);
  }

}
