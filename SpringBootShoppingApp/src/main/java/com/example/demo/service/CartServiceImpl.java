package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
	
	CartRepository cartRepository;

	@Override
	public Cart addToCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public  Optional<Cart> getCart(int cartId) {
		return cartRepository.findById(cartId);
	}

	@Override
	public String removeCart(int cartId) {
		cartRepository.deleteById(cartId);
		return "cart deleted successfully";
	}



}
