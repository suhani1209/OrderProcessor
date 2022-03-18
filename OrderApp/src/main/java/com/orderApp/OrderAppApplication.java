package com.orderApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class OrderAppApplication implements CommandLineRunner{

//	@Autowired
//	private OrderService orderService;
//	
//	@Autowired
//	private UserService userService;
	
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
		
//		userService.addUser(new User("suhani", "1230","abc@gmail.com", "greater noida", "123456789"));
//		System.out.println("user added ...");
		
//		System.out.println(orderService.getOrderByUser(2));
	}

}
