package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="products")
public class Product {
	
	@Id
	private int productId;
	private String productName;
	private int productPrice;
	private String productCategory;
	private Date productValidity;
}
