package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	Logger Logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/save")
	public String saveProduct(@RequestBody Product product) {
		Logger.info("In controller /save" + product);
		return productService.addProduct(product);
	}

	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		Logger.info("In controller /update" + product);
		return productService.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int productId) {
		Logger.info("In controller /delete" + productId);
		return productService.deleteProduct(productId);
	}

	@GetMapping("/getById/{id}")
	public Product getProductById(@PathVariable("id") int productId) throws ProductNotFoundException {
		Logger.info("In controller /getById" + productId);
		return productService.getProductById(productId);
	}

	@GetMapping("/getAllProducts")
	public List<Product> saveProduct() {
		Logger.info("In controller /getAllProducts");
		return productService.getAllProducts();
	}

	@GetMapping("/getAllProductsBetween/{price1}/{price2}")
	public List<Product> getAllProductsBetween(@PathVariable("price1") int initialPrice,
			@PathVariable("price2") int finalPrice) {
		Logger.info("In controller /getAllProductsBetween " + initialPrice + " " + finalPrice);
		return productService.getAllProductsBetweenPrice(initialPrice, finalPrice);
	}

	@GetMapping("/getProductsByCategory/{category}")
	public List<Product> getProductByCategory(@PathVariable("category") String category) {
		Logger.info("In controller /getProductByCategory" + category);
		return productService.getProductsByCategory(category);
	}

	@GetMapping("/getAllProductsByCategoryAndPrice/{category}/{price}")
	public List<Product> getProductByCategoryAndPrice(@PathVariable("category") String category,
			@PathVariable("price") int price) {
		Logger.info("In controller /getAllProductsByCategoryAndPrice " + category + " " + price);
		return productService.getProductsByCategoryAndPrice(category, price);
	}

	@GetMapping("/getValidProducts/{date}")
	public List<Product> getValidProducts(@PathVariable("date") String validDate) {
		Logger.info("In controller /getValidProducts " + validDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(validDate, formatter);
		return productService.findByProductValidityBefore(date);
	}

	@PostMapping("/test")
	public String receiveUser(@RequestBody User user) {
		// Process the received user data
		Logger.info("In controller " + user);
		return "User data received successfully!";
	}
}
