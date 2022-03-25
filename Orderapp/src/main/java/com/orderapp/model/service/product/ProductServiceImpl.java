package com.orderapp.model.service.product;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderapp.model.dao.product.Product;
import com.orderapp.model.dao.product.ProductDao;

@Service 
@Transactional
public class ProductServiceImpl implements ProductService{
	private ProductDao productdao;
	
	@Autowired
	public ProductServiceImpl(ProductDao productDao)
	{
		this.productdao=productDao;
	}
	
	
	@Override
	public List<Product> getAllProducts() {
		return productdao.findAll();
	}

}
