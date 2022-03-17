package com.orderApp.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;
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
	private LocalDate orderedOn;
	private LocalTime orderTime;
	private User user;
	
	private List<Product> products;
}
