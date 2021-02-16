import { Component, OnInit } from '@angular/core';
import { Books } from '../books';
import { ActivatedRoute, Router } from '@angular/router';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-books-details',
  templateUrl: './books-details.component.html',
  styleUrls: ['./books-details.component.css']
})
export class BooksDetailsComponent implements OnInit {
  id: number
  books: Books
  
  constructor(private route: ActivatedRoute, private booksService: BooksService,private router:Router) { }

  ngOnInit(): void {

    if(!sessionStorage.getItem("sid")){
      this.router.navigate(["liblogin"]);
    }
    this.id = this.route.snapshot.params['id'];

    this.books = new Books();
    this.booksService.getBooksById(this.id).subscribe( data => {
      this.books = data;
    });
  
  }
backHome(){
  this.router.navigate(['librarianhome']);
}



}
