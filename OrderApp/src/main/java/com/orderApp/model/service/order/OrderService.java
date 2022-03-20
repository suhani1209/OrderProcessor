package com.orderApp.model.service.order;

import java.util.List;

import com.orderApp.model.dao.order.Order;
import com.orderApp.model.dao.product.Product;

public interface OrderService {
	
	public List<Order> getAllOrders();
	public Order getByOrderId(Integer orderId);
	public void addOrder(List<Product> products,Integer id);
	public Order updateOrder(Integer orderId,Order order);
	public Order deleteOrder(Integer orderId);
	public List<Order> getOrderByUser(Integer userId);
}