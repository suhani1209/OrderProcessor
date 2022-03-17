package com.orderApp.model.dao.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product_table")
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String productName;
	private String productCategory;
	
	public Product(String productName, String productCategory) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
	}
	
	
}
