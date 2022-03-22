package com.orderApp.model.dto;

import com.orderApp.model.dao.order.Order;

public class DtoUtil {
	
	/************METHOD TO CONVERT ORDER DTO TO ORDER 
	 *********USE : WHEN USER WANT TO UPDATE ORDER THE UPDATED DETAILS ARE STORED IN ORDER DTO (FORM BEAN)*****
	 ************** NOW CONVERT TO ORDER IS USED SO THIS FORM BEAN COULD BE USED TO UPDATE ORDER***************
	 *************** POST MAPPING IN UPDATE
	 *********************************/
	public static Order convertToOrder(OrderDto orderDto)
	{
		Order order=new Order();
		order.setOrderedOn(orderDto.getOrderedOn());
		order.setOrderId(orderDto.getOrderId());
		order.setProducts(orderDto.getProducts());
		order.setStatus(orderDto.getStatus());
		order.setUser(orderDto.getUser());
		return order;
	}
	
	/******** FOR DISPLAYING PREFILLED DETAILS TO USER ALL DETAILS ARE PASSED WITH FORM BEAN 
	 ***************SO THIS METHOD PUTS ALL ORDER DETAILS IN ORDER DTO***************
	 ******USE : GET MAPPING IN UPDATE ****************************************************/
	public static OrderDto convertToOrderDto(Order order)
	{
		OrderDto orderDto=new OrderDto();
		orderDto.setOrderedOn(order.getOrderedOn());
		orderDto.setOrderId(order.getOrderId());
		orderDto.setProducts(order.getProducts());
		orderDto.setStatus(order.getStatus());
		orderDto.setUser(order.getUser());
		return orderDto;
	}
}
