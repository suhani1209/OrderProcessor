package com.orderApp.model.service.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderApp.model.dao.order.Order;
import com.orderApp.model.dao.order.OrderDao;
import com.orderApp.model.dao.product.Product;
import com.orderApp.model.exception.OrderNotFoundException;
import com.orderApp.model.service.user.UserService;

@Service 
@Transactional
public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao;
	@Autowired
	private UserService userService;
	
	@Autowired
	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao=orderDao;
	}
	
	//GETTING ALL THE ORDERS 
	@Override
	public List<Order> getAllOrders() {
		
		return orderDao.findAll();
	}

	//GETTING ORDER BY ORDER ID
	@Override
	public Order getByOrderId(Integer orderId) {
		
		return orderDao.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with the entered order id: " + orderId + " is not found"));
	}
	
	//ADDING NEW ORDER USER ENTERS LIST OF PRODUCTS TO BE ADDED 
	@Override
	public void addOrder(List<Product> products,Integer id) {
		Order order=new Order(products);
		order.setUser(userService.findById(id));
		orderDao.save(order);
	}

	//UPDATING ORDER DETAILS 
	@Override
	public Order updateOrder(Integer orderId, Order order) {
		Order orderToUpdate = orderDao.getById(orderId);
		orderToUpdate.setProducts(order.getProducts());
		orderDao.save(orderToUpdate);
		return orderToUpdate;
	}

	//SOFT DELETE OF ORDER (CHANGING STATUS TO DELETED)
	@Override
	public Order deleteOrder(Integer orderId) {
		Order orderToDelete=orderDao.getById(orderId);
		orderToDelete.setStatus("DELETED");
		orderDao.save(orderToDelete);
		return orderToDelete;
	}
	
	//GETTING ALL ORDERS OF A PARTICULAR USER WITH GIVEN USER ID
	@Override
	public List<Order> getOrderByUser(Integer userId) {
		return orderDao.getOrderByUser(userId);
	}
	
	//SEARCHING ORDER BY ORDER ID
	@Override
	public List<Order> findAll(Integer id) {
		if(id!=null) {
			return orderDao.findAll(id);
		}
		return orderDao.findAll();
	}
	

}
