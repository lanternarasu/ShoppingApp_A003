package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	Logger Logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public String addProduct(Product product) {
		Logger.info("in service"+product);
		Product result = productRepository.save(product);
		if(result!=null)
			return "product added successfully";
		else
			return "product not added";
	}

}
