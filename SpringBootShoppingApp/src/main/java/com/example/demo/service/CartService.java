package com.example.demo.service;

import com.example.demo.model.Cart;

public interface CartService {
	public Cart addToCart(Cart cart);
	public Cart getCart();
	public String removeCart(int cartId);
}
