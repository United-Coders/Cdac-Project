import { BooksService } from './../books.service';
import { Component, OnInit } from '@angular/core';
import { Books } from '../books';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-books',
  templateUrl: './update-books.component.html',
  styleUrls: ['./update-books.component.css']
})
export class UpdateBooksComponent implements OnInit {

  id: number;
  books: Books = new Books();
  constructor(private booksService: BooksService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {

    if(!sessionStorage.getItem("sid")){
      this.router.navigate(["liblogin"]);
    }
    this.id = this.route.snapshot.params['id'];
    this.booksService.getBooksById(this.id).subscribe(data => {
      this.books = data;
    }, error => console.log(error));
  }

  onSubmit() {
    this.booksService.updateBook(this.id, this.books).subscribe( data => {
      this.goToBookList();
    }
    , error => console.log(error));
  }

  goToBookList() {
    this.router.navigate(['/booklist']);
  }

}