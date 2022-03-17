package com.orderApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orderApp.model.dao.order.Order;
import com.orderApp.model.dao.product.Product;
import com.orderApp.model.service.OrderService;

@SpringBootApplication
public class OrderAppApplication implements CommandLineRunner{

	@Autowired
	private OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Product> prod=new ArrayList<>();
//		prod.add(new Product("bottle", "plastic"));
//		prod.add(new Product("tshirt", "clothing"));
//		orderService.addOrder(new Order(prod));
		//orderService.updateOrder(1, new Order(prod));
//		List<Order> orders=orderService.getAllOrders();
//		for(Order o:orders) {
//			System.out.println(o);
//		}
	}

}
