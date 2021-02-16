package com.cdac.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Cart;


@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{

}
