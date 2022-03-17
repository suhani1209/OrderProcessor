package com.orderApp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.orderApp.model.dao.order.Order;
import com.orderApp.model.dto.DtoUtil;
import com.orderApp.model.dto.OrderDto;
import com.orderApp.model.service.OrderService;
import com.orderApp.model.service.ProductService;

@Controller
public class OrderCrudController {
	
	private OrderService orderService;
	private ProductService productService;
	
	@Autowired
	public OrderCrudController(OrderService orderService, ProductService productService)
	{
		this.orderService=orderService;
		this.productService=productService;
	}
	
	//home page
	@GetMapping(path="/")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("home");
		mv.addObject("products",productService.getAllProducts());
		return mv;
	}
	// view all orders ...
	@GetMapping(path="orders")
	public ModelAndView getAllOrders(ModelAndView mv){
		mv.setViewName("allorders");
		List<Order>orders=orderService.getAllOrders();
		mv.addObject("orders", orders);
		return mv;
	}
	
	// delete order...
	@GetMapping(path="orders/delete/{id}")
	public String deleteOrder(@PathVariable(name = "id")  Integer id) {
		orderService.deleteOrder(id);
		return "redirect:../../orders";
	}
	
	
	// update order...
	@GetMapping(path="orders/update/{id}")
	public ModelAndView updateOrder(ModelAndView mv,@PathVariable(name = "id")  Integer id) {
		mv.setViewName("updateorder");
		Order order=orderService.getByOrderId(id);
		mv.addObject("id",order.getOrderId());
		mv.addObject("orderDto", DtoUtil.convertToOrderDto(order));
		mv.addObject("products",productService.getAllProducts());
		
		return mv;
	}

	@PostMapping(path="orders/update/{id}")
	public String updateAccountPost(@ModelAttribute OrderDto orderDto,@PathVariable(name = "id")  Integer id){
		System.out.println(id);
		System.out.println(orderDto.getOrderId()+"*******************");
		orderService.updateOrder(id, DtoUtil.convertToOrder(orderDto));
		return "redirect:../../orders";
	}
	
	// add order..
	
	
	
	
}
