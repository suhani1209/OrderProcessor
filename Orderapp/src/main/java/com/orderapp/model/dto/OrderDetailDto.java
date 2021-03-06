package com.orderapp.model.dto;

import java.util.List;

import com.orderapp.model.dao.product.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
	/**USE : ADD ORDER 
	 *STORED THE PRODUCTS WHICH USER SELECTED FOR ADDING IN NEW ORDER
	 **/
	private List<Product> products;
}
