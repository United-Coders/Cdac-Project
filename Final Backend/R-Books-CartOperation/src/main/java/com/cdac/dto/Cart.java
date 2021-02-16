package com.cdac.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	
	    @Id
	   @GeneratedValue
    private int cartId; 
	    @OneToOne
	    @JoinColumn(name = "BookId")
	    private Books books;
//    private String cbookName;
//    private String cauthorName;
//    private int cbookPrice;
    private int userId;
    
    
    
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
    
	
	
}
