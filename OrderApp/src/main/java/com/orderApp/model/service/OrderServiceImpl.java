package com.orderApp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderApp.model.dao.order.Order;
import com.orderApp.model.dao.order.OrderDao;
import com.orderApp.model.dao.product.Product;
import com.orderApp.model.exception.OrderNotFoundException;

@Service 
@Transactional
public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao;
	
	@Autowired
	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao=orderDao;
	}
	@Override
	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public Order getByOrderId(Integer orderId) {
		
		return orderDao.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with the entered order id: " + orderId + " is not found"));
	}

	@Override
	public void addOrder(Order order) {
		orderDao.save(order);
	}

	@Override
	public Order updateOrder(Integer orderId, Order order) {
		Order orderToUpdate = orderDao.getById(orderId);
		orderToUpdate.setProducts(order.getProducts());
		orderDao.save(orderToUpdate);
		return orderToUpdate;
	}

	@Override
	public Order deleteOrder(Integer orderId) {
		Order orderToDelete=orderDao.getById(orderId);
		orderToDelete.setStatus("DELETED");
		orderDao.save(orderToDelete);
		return orderToDelete;
	}

}
