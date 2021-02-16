package com.cdac.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.Service.CartService;
import com.cdac.dto.Cart;
import com.cdac.dto.Message;
import com.cdac.dto.User;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping(value = "registerCart")
	public Message index(@RequestBody Cart cart) {
			System.out.println(cart);
			if(cartService.AddCart(cart)) {
				return new Message("Cart Added", true);
			}
			
			return new Message("Cart not Added", false);
	}
	
	
	@DeleteMapping(value = "deleteCart/{id}")
	public Message deleteCart(@PathVariable int id) {
			System.out.println(id);
			cartService.deleteCart(id);
			return new Message("Cart Removed",true);
	}
	
	@GetMapping(value = "displayCart" )
	public List<Cart> getCart() {
	
			return cartService.getAllCart();
	}
}
