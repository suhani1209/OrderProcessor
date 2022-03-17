package com.orderApp.model.dto;

import com.orderApp.model.dao.order.Order;

public class DtoUtil {
	public static Order convertToOrder(OrderDto orderDto)
	{
		Order order=new Order();
		order.setOrderTime(orderDto.getOrderTime());
		order.setOrderedOn(orderDto.getOrderedOn());
		order.setOrderId(orderDto.getOrderId());
		order.setProducts(orderDto.getProducts());
		order.setStatus(orderDto.getStatus());
		order.setUser(orderDto.getUser());
		return order;
	}
	public static OrderDto convertToOrderDto(Order order)
	{
		OrderDto orderDto=new OrderDto();
		orderDto.setOrderedOn(order.getOrderedOn());
		orderDto.setOrderId(order.getOrderId());
		orderDto.setOrderTime(order.getOrderTime());
		orderDto.setProducts(order.getProducts());
		orderDto.setStatus(order.getStatus());
		orderDto.setUser(order.getUser());
		return orderDto;
	}
}
