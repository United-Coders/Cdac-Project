package com.cdac.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Repository.CartRepository;
import com.cdac.dto.Cart;



@Service
public class CartServiceImple implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	
	@Override
	public boolean AddCart(Cart cart) {
		if(null == cartRepository.save(cart)) {
			return false;
		}
		return true;
	}


	@Override
	public List<Cart> getAllCart() {
		Iterable<Cart> UI = cartRepository.findAll();
		Iterator<Cart> UItr = UI.iterator();
		List<Cart> ULi = new ArrayList<Cart>();
		while(UItr.hasNext()) {
			ULi.add(UItr.next());
		}
		return ULi;
	}


	@Override
	public boolean deleteCart(int id) {
		cartRepository.deleteById(id);
		return true;
	}
	
	@Override
	public Cart getCartById(int id) {
		Optional<Cart> cartOpt = cartRepository.findById(id);
		if(cartOpt.isPresent()) {
			return cartOpt.get();
		}
		return null;
	}

}
