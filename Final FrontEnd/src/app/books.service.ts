import { Books } from './books';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cart } from './cartservice.service';

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  private baseURL = "http://localhost:8080/Books";

  private baseURL1 = "http://localhost:8080/AddBooks";

  private baseURL2 = "http://localhost:8080/deleteBooks";

  private baseURL3 = "http://localhost:8080/update-books";

  private baseURL4 = "http://localhost:8080/registerCart";

  private baseURL5= "http://localhost:8080/getbooks";

 private baseURL6 = "http://localhost:8080/submitPaymentDetail";

  constructor(private httpClient: HttpClient) { }
  getBooksList(): Observable<Books[]> {
    return this.httpClient.get<Books[]>(`${this.baseURL}`);
  }

  addBooks(books: Books): Observable<object> {
    return this.httpClient.post(`${this.baseURL1}`, books);
  }

  deleteBooks(id: number): Observable<object> {
    return this.httpClient.delete(`${this.baseURL2}/${id}`);
  }

  getBooksById(id: number): Observable<Books> {
    return this.httpClient.get<Books>(`${this.baseURL5}/${id}`);
  }

  updateBook(id: number, books: Books): Observable<object> {
    return this.httpClient.put(`${this.baseURL3}/${id}`, books);
  }

  addtoCart(cart : Cart): Observable<object> {
    return this.httpClient.post(`${this.baseURL4}`, cart);
  }

  addPayment(id:number): Observable<object> {
    return this.httpClient.post(`${this.baseURL6}`,id );
  }
}