package com.cdac.Service;

import java.util.List;

import com.cdac.dto.Cart;

public interface CartService {

	    boolean AddCart(Cart cart);
		
		List<Cart> getAllCart();
		
		boolean deleteCart(int id);

		public Cart getCartById(int id);
	    
	
	
}
