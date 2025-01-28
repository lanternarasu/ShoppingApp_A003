package com.example.demo.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
	
	CartService cartService;
	
	@PostMapping("/save")
	public Cart saveCart(@RequestBody Cart cart) {
		return cartService.addToCart(cart);
	}
	
	@GetMapping("/get/{id}")
	public Optional<Cart> getCart(@PathVariable("id") int cartId){
		return cartService.getCart(cartId);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCart(@PathVariable("id") int cartId) {
		return cartService.removeCart(cartId);
	}
}
