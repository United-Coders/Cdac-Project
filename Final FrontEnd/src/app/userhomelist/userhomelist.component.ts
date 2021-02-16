import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartserviceService ,Cart }  from './../cartservice.service';
import { BooksService } from './../books.service';
import { Books } from './../books';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
@Component({
  selector: 'app-userhomelist',
  templateUrl: './userhomelist.component.html',
  styleUrls: ['./userhomelist.component.css']
})
export class UserhomelistComponent implements OnInit {

  search : any;

  private id;
  Bookss: Books[];
  bookss: Books = new Books();
  //cart: Cart = new Cart( null ,null, null, null, null);
  constructor(private cartserviceService: CartserviceService,private booksService: BooksService,
    private router: Router) { }

  ngOnInit(): void {
    if(!sessionStorage.getItem("sid")){
      this.router.navigate(["login"]);
    }
    this.getBooks();
  }

  private getBooks() {
    this.booksService.getBooksList().subscribe(data => {
      this.Bookss = data;
    });
  }



//  saveBook(id) {
// this.booksService.addtoCart(this.id,this.bookss).subscribe(data => {
//     console.log(data);
//     this.gotoBookList();
//   },
//     error => console.log(error));
// }

// gotoBookList() {
//   this.router.navigate(['addtocart']);
// }

cartAdd(book :Books) {

let cart: Cart = new Cart();
cart.books = book;

cart.userId = parseInt(sessionStorage.getItem('userId'));
this.booksService.addtoCart(cart).subscribe(data => {
  console.log(data);
  this.router.navigate(['addtocart',book.bookId]);
},  error => console.log(error));


  
}


}
