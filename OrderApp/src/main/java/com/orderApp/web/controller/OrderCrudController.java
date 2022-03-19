package com.orderApp.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.orderApp.model.dao.order.Order;
import com.orderApp.model.dao.user.User;
import com.orderApp.model.dto.DtoUtil;
import com.orderApp.model.dto.OrderDetailDto;
import com.orderApp.model.dto.OrderDto;
import com.orderApp.model.service.order.OrderService;
import com.orderApp.model.service.product.ProductService;
import com.orderApp.model.service.user.UserService;

@Controller
public class OrderCrudController {
	
	private OrderService orderService;
	private ProductService productService;
	private UserService userService;
	
	@Autowired
	public OrderCrudController(OrderService orderService, ProductService productService,UserService userService)
	{
		this.orderService=orderService;
		this.productService=productService;
		this.userService=userService;
	}
	
	//home page
	@GetMapping(path = "/home")
	public ModelAndView sayHome(Principal principal,ModelAndView mv) {
		System.out.println("**"+principal.getName());
		User user=userService.findByUsername(principal.getName());
		mv.setViewName("home");
		mv.addObject("products",productService.getAllProducts());
		mv.addObject("user",user);
		System.out.println("**"+user);
		return mv;
	}
	
	// view all orders ...
	@GetMapping(path="orders/{id}")
	public ModelAndView getAllOrders(ModelAndView mv,@PathVariable(name="id") Integer id){
		mv.setViewName("allorders");
		List<Order>orders=orderService.getOrderByUser(id);
		System.out.println("**came for all orders "+id);
		mv.addObject("userid",id);
		mv.addObject("orders", orders);
		return mv;
	}
	
	// delete order...
	@GetMapping(path="orders/{userid}/delete/{id}")
	public String deleteOrder(@PathVariable(name = "userid")  Integer userid,@PathVariable(name = "id")  Integer orderId) {
		orderService.deleteOrder(orderId);
		return "redirect:../../../orders/{userid}";
	}
	
	
	// update order...
	@GetMapping(path="orders/{userid}/update/{id}")
	public ModelAndView updateOrder(@PathVariable(name = "userid")  Integer userid,ModelAndView mv,@PathVariable(name = "id")  Integer id) {
		mv.setViewName("updateorder");
		System.out.println("**came for update "+userid);
		Order order=orderService.getByOrderId(id);
		mv.addObject("userid",userid);
		mv.addObject("id",order.getOrderId());
		mv.addObject("orderDto", DtoUtil.convertToOrderDto(order));
		mv.addObject("products",productService.getAllProducts());
		
		return mv;
	}

	@PostMapping(path="orders/{userid}/update/{id}")
	public String updateAccountPost(@PathVariable(name = "userid")  Integer userid,@ModelAttribute OrderDto orderDto,@PathVariable(name = "id")  Integer id){
		System.out.println(id);
		System.out.println(orderDto.getOrderId()+"**");
		orderService.updateOrder(id, DtoUtil.convertToOrder(orderDto));
		return "redirect:../../../orders/{userid}";
	}
	
	// add order..
	@GetMapping(path="addorder/{id}")
	public ModelAndView accountsGet(ModelAndView mv,@PathVariable(name = "id")  Integer id) {
		mv.setViewName("addorder");
		System.out.println("**came for adding product.."+ id);
		mv.addObject("userid",id);
		mv.addObject("allproducts",productService.getAllProducts());
		mv.addObject("orderDto",new OrderDetailDto());
		return mv;
	}
	
	@PostMapping(path="addorder/{id}")
	public String accountsPost(@ModelAttribute OrderDetailDto orderDto,@PathVariable(name = "id")  Integer id){
		System.out.println("**user wants to add product"+id);
		orderService.addOrder(orderDto.getProducts(), id);
		return "redirect:../orders/{id}";
	}
	
	
	// view order detailss
	@GetMapping(path="/orders/{userid}/view/{orderId}")
	public ModelAndView viewOrderDetails(ModelAndView mv,@PathVariable(name = "orderId")  Integer orderId)
	{
		mv.setViewName("vieworder");
		mv.addObject("order",orderService.getByOrderId(orderId));
		return mv;
	}
	
	// search order by id
	@PostMapping(path="/orders/{userid}/view")
	public ModelAndView searchByOrderNumber(ModelAndView mv,@RequestParam(name="searchId") Integer orderid)
	{
		System.out.println(orderid);
		System.out.println("**search by order number "+ orderid);
		mv.setViewName("vieworder");
		Order order=orderService.getByOrderId(orderid);
		System.out.println(order);
		mv.addObject("order",order);
		return mv;
	}
}
