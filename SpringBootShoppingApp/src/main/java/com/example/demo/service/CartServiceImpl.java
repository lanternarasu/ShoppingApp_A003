package com.example.demo.service;

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
	public Cart updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProductInCart(int cartId, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
