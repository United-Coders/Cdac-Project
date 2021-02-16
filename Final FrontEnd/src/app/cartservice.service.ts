import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Books } from './books';

export class Cart {

  public cartId: number;
  public books: Books;
  public userId: number;
  constructor(
   
    ) { }


}


@Injectable({
  providedIn: 'root'
})
export class CartserviceService {

  constructor(private httpClient: HttpClient,
    private router: Router) { }


    public addtoCart(obj: any) {
      return this.httpClient.post<any>("http://localhost:8080/registerCart", <Cart>obj);
    }
}
