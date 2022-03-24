package com.orderApp.model.service.product;

import java.util.List;

import com.orderApp.model.dao.product.Product;

public interface ProductService {
	// FETCHING LIST OF ALL PRODUCTS 
	public List<Product> getAllProducts();
}
