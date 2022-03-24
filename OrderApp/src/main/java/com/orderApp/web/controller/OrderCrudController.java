package com.orderApp.web.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	public OrderCrudController(OrderService orderService, ProductService productService, UserService userService) {
		this.orderService = orderService;
		this.productService = productService;
		this.userService = userService;
	}

	/**HOME PAGE AUTHENTICATED USER WILL FIRST COME AT THIS PAGE
	 **/
	@GetMapping(path = "/home")
	public ModelAndView sayHome(Principal principal, ModelAndView mv,HttpSession session) {
		User user = userService.findByUsername(principal.getName());
		/* session.setAttribute("user", user); */
		mv.setViewName("home");
		mv.addObject("products", productService.getAllProducts());
		mv.addObject("user", user);
		return mv;
	}

	/**VIEW ALL ORDERS OF A USER
	 * INPUT PARAMETERS : USER ID
	 **/
	@GetMapping(path = "orders/{id}")
	public ModelAndView getAllOrders(ModelAndView mv, @PathVariable(name = "id") Integer id) {
		mv.setViewName("allorders");
		List<Order> orders = orderService.getOrderByUser(id);
		mv.addObject("user", userService.findById(id));
		mv.addObject("orders", orders);
		return mv;
	}

	
	/**SEARCH ORDER BY ORDER ID
	 *INPUT PARAMETERS : USER ID, ORDER ID (FOR WHICH SEARCH HAS TO BE PERFORMED)
	 ***/
	@PostMapping(path = "orders/{userid}")
	public ModelAndView getOrderById(ModelAndView mv,@RequestParam(name = "searchId") Integer orderid,@PathVariable(name = "userid") Integer userid ) {
		mv.setViewName("allorders");
		List<Order> orders = orderService.findAll(orderid);
		mv.addObject("user", userService.findById(userid));
		if(orders.size()==0)
		{
			mv.addObject("message", "Order with id : "+orderid+" does not exist");
			return mv;
		}
		mv.addObject("orders", orders);
		return mv;
	}

	/**DELETE ORDER
	 *INPUT PARAMETERS : USER ID, ORDER ID
	 **/
	@GetMapping(path = "orders/{userid}/delete/{id}")
	public String deleteOrder(@PathVariable(name = "userid") Integer userid,@PathVariable(name = "id") Integer orderId) {
		orderService.deleteOrder(orderId);
		return "redirect:../../../orders/{userid}?success=Order deleted successfully";
	}

	
	/**UPDATE ORDER
	 *INPUT PARAMETERS USER ID, ORDER ID(ORDER TO BE UPDATED
	 **/
	@GetMapping(path = "orders/{userid}/update/{id}")
	public ModelAndView updateOrder(@PathVariable(name = "userid") Integer userid, ModelAndView mv,@PathVariable(name = "id") Integer id) {
		mv.setViewName("updateorder");
		Order order = orderService.getByOrderId(id);
		mv.addObject("user", userService.findById(userid));
		mv.addObject("id", order.getOrderId());
		mv.addObject("orderDto", DtoUtil.convertToOrderDto(order));
		mv.addObject("products", productService.getAllProducts());
		return mv;
	}

	@PostMapping(path = "orders/{userid}/update/{id}")
	public String updateAccountPost(@PathVariable(name = "userid") Integer userid, @ModelAttribute OrderDto orderDto,
			@PathVariable(name = "id") Integer id) {
		orderService.updateOrder(id, DtoUtil.convertToOrder(orderDto));
		return "redirect:../../../orders/{userid}?success=Order Updated successfully";
	}

	
	// ADD ORDER 
	@GetMapping(path = "addorder/{id}")
	public ModelAndView accountsGet(ModelAndView mv, @PathVariable(name = "id") Integer id) {
		mv.setViewName("addorder");
		mv.addObject("user", userService.findById(id));
		mv.addObject("allproducts", productService.getAllProducts());
		mv.addObject("orderDto", new OrderDetailDto());
		return mv;
	}

	@PostMapping(path = "addorder/{id}")
	public String accountsPost(@ModelAttribute OrderDetailDto orderDto, @PathVariable(name = "id") Integer id) {
		
		/** Validation if user does not select any product then don't place an order 
		 * instead REDIRECT TO ADD ORDER PAGE and display error message
		 * */
		if(orderDto.getProducts().size()<1)
		{
			return "redirect:../addorder/{id}?danger=Select at least one product to place order";
		}
		
		/** ADD ORDER 
		 *  redirect to all orders page with success message
		 **/
		orderService.addOrder(orderDto.getProducts(), id);
		return "redirect:../orders/{id}?success=Order Created Succesfully";
	}

	
	/**VIEW ORDER BY ORDER ID
	 *INPUT PARAMETER : USER ID, ORDER ID(WHOSE DETAILS ARE TO BE VIEWED)
	 **/
	@GetMapping(path = "/orders/{userid}/view/{orderId}")
	public ModelAndView viewOrderDetails(ModelAndView mv, @PathVariable(name = "orderId") Integer orderId,
			@PathVariable(name = "userid") Integer userid) {
		mv.setViewName("vieworder");
		mv.addObject("user", userService.findById(userid));
		mv.addObject("order", orderService.getByOrderId(orderId));
		return mv;
	}

}
