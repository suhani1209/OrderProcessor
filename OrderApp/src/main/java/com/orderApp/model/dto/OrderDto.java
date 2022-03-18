package com.orderApp.model.dto;


import java.time.LocalDateTime;
import java.util.List;

import com.orderApp.model.dao.product.Product;
import com.orderApp.model.dao.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	private Integer orderId;
	private String status;
	private LocalDateTime orderedOn;
	private User user;
	
	private List<Product> products;
}
