package com.orderapp.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.orderapp.model.dao.order.Order;
import com.orderapp.model.dao.user.User;
import com.orderapp.model.dto.DtoUtil;
import com.orderapp.model.dto.OrderDetailDto;
import com.orderapp.model.dto.OrderDto;
import com.orderapp.model.service.order.OrderService;
import com.orderapp.model.service.product.ProductService;
import com.orderapp.model.service.user.UserService;

@Controller
public class OrderController {

	private OrderService orderService;
	private ProductService productService;
	private UserService userService;

	@Autowired
	public OrderController(OrderService orderService, ProductService productService, UserService userService) {
		this.orderService = orderService;
		this.productService = productService;
		this.userService = userService;
	}

	/**HOME PAGE AUTHENTICATED USER WILL FIRST COME AT THIS PAGE
	 **/
	@GetMapping(path = "/home")
	public ModelAndView sayHome(Principal principal, ModelAndView mv,HttpSession session) {
		User user = userService.findByUsername(principal.getName());
		session.setAttribute("user", user);
		mv.setViewName("home");
		mv.addObject("products", productService.getAllProducts());
		return mv;
	}

	/**VIEW ALL ORDERS OF A USER
	 * INPUT PARAMETERS : USER ID
	 **/
	
	@GetMapping(path="orders")
	public ModelAndView getAllOrder(ModelAndView mv,HttpSession session)
	{
		mv.setViewName("allorders");
		User userid=(User)session.getAttribute("user");
		mv.addObject("orders",orderService.getOrderByUser(userid.getId()));
		return mv;
	}


	/**DELETE ORDER
	 *INPUT PARAMETERS : USER ID, ORDER ID
	 **/
	@GetMapping(path="delete/{orderid}")
	public String deleteOrder(@PathVariable(name="orderid") Integer orderId)
	{
		orderService.deleteOrder(orderId);
		return "redirect:/orders?success=Order deleted successfully";
	}

	
	/**UPDATE ORDER
	 *INPUT PARAMETERS USER ID, ORDER ID(ORDER TO BE UPDATED
	 **/
	
	@GetMapping(path = "update")
	public ModelAndView updateOrder(ModelAndView mv,@RequestParam(name = "orderid") Integer orderid) {
		mv.setViewName("updateorder");
		Order order = orderService.getByOrderId(orderid);
		mv.addObject("orderDto", DtoUtil.convertToOrderDto(order));
		mv.addObject("products", productService.getAllProducts());
		return mv;
	}
	@PostMapping(path = "update/{orderid}")
	public String updateAccountPost(@ModelAttribute OrderDto orderDto,@PathVariable(name = "orderid") Integer orderid) {
		orderService.updateOrder(orderid, DtoUtil.convertToOrder(orderDto));
		return "redirect:/orders?success=Order Updated successfully";
	}

	
	// ADD ORDER 
	@GetMapping(path = "addorder")
	public ModelAndView accountsGet(ModelAndView mv) {
		mv.setViewName("addorder");
		mv.addObject("allproducts", productService.getAllProducts());
		mv.addObject("orderDto", new OrderDetailDto());
		return mv;
	}

	@PostMapping(path = "addorder")
	public String accountsPost(@ModelAttribute OrderDetailDto orderDto,HttpSession session) {
		User user=(User)session.getAttribute("user");
		/** Validation if user does not select any product then don't place an order 
		 * instead REDIRECT TO ADD ORDER PAGE and display error message
		 * */
		if(orderDto.getProducts().isEmpty())
		{
			return "redirect:../addorder?danger=Select at least one product to place order";
		}
		
		/** ADD ORDER 
		 *  redirect to all orders page with success message
		 **/
		orderService.addOrder(orderDto.getProducts(), user.getId());
		return "redirect:../orders?success=Order Created Succesfully";
	}

	
	/**VIEW ORDER BY ORDER ID
	 *INPUT PARAMETER : USER ID, ORDER ID(WHOSE DETAILS ARE TO BE VIEWED)
	 **/
	
	@GetMapping(path = "view")
	public ModelAndView viewOrderDetails(ModelAndView mv, @RequestParam(name="orderid") Integer orderid,HttpSession session) {
		mv.setViewName("vieworder");
		User user=(User)session.getAttribute("user");
		mv.addObject("order", orderService.getOrderByUserId(user.getId(), orderid));
		return mv;
	}
}