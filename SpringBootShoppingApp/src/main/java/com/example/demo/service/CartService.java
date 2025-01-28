package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Cart;

public interface CartService {
	public Cart addToCart(Cart cart);
	public Optional<Cart> getCart(int cartId);
	public String removeCart(int cartId);
}
