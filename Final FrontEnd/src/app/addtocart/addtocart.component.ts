import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Books } from '../books';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-addtocart',
  templateUrl: './addtocart.component.html',
  styleUrls: ['./addtocart.component.css']
})
export class AddtocartComponent implements OnInit {
  public  routeSub: Subscription; 
  id: number
  books: Books
  constructor(private router: Router,private route: ActivatedRoute,private booksService: BooksService) { }

  ngOnInit(): void {

    if(!sessionStorage.getItem("sid")){
      this.router.navigate(["login"]);
    }
    // this.routeSub = this.route.params.subscribe(params => { console.log(params) //log the entire params object
    //    console.log(params['id']) //log the value of id
       
    //    });

       this.id = this.route.snapshot.params['id'];

       this.books = new Books();
       this.booksService.getBooksById(this.id).subscribe( data => {
         this.books = data;
       });
  }



  payment(){
  this.booksService.addPayment(62).subscribe(data =>{
      console.log(data);
    //this.router.navigate(['payment']);
  });

  }
}

