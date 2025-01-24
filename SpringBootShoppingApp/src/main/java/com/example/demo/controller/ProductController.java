package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	Logger Logger=LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/save")
	public String saveProduct(@RequestBody Product product){
		Logger.info("In controller "+product);
		return productService.addProduct(product);
	} 
	 @PostMapping("/test")
	 public String receiveUser(@RequestBody User user) {
	        // Process the received user data
		 Logger.info("In controller "+user);
	     return "User data received successfully!";
	    }
}
