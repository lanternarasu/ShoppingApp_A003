package com.example.demo.service;

import com.example.demo.model.Cart;

public interface CartService {
	public Cart addToCart(Cart cart);
	public Cart updateCart(Cart cart);
	public String deleteProductInCart(int cartId,int productId);
}
