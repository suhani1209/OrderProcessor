package com.orderApp.model.service.order;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.orderApp.model.dao.order.Order;
import com.orderApp.model.dao.product.Product;

public interface OrderService {
	
	/**FETCHING ALL THE ORDERS WHICH ARE NOT DELETED 
	 *AND PLACED BY THE USER WHOSE USER ID IS ENTERED 
	 *INPUT PARAMETERS : USER ID **/
	
	@Query(value="select * from order_table where status<> 'DELETED' and order_id=?1", 
			  nativeQuery = true)
	public List<Order> findAll(Integer id);
	
	//FETCHING LIST OF ALL ORDERS
	public List<Order> getAllOrders();
	
	/**FETCHING ORDER GIVEN ORDER ID 
	 * INPUT PARAMETER : ORDER ID
	 **/
	public Order getByOrderId(Integer orderId);
	
	/**ADD ORDER 
	 * INPUT PARAMETER : LIST OF PRODUCTS ORDERED, USER ID(WHICH USER PLACED ORDER
	 **/
	public void addOrder(List<Product> products,Integer id);
	
	/**UPDATE ORDER 
	 * INPUT PARAMETER : ORDER ID 
	 * **/
	public Order updateOrder(Integer orderId,Order order);
	
	/**DELETE ORDER
	 * INPUT PARAMETER : ORDER ID 
	 * **/
	public Order deleteOrder(Integer orderId);
	
	/**FETCHING ALL THE ORDERS WHICH A PARTICULAR USER PLACED
	 * INPUT PARAMETER : USER ID
	 * **/
	public List<Order> getOrderByUser(Integer userId);
	
	/**
	 * Finding a particular order associated with particular user
	 * @param userid, orderid
	 */
	@Query(value="select * from order_table where user_id=?1 and order_id=?2",nativeQuery = true)
	public Order getOrderByUserId(Integer userid,Integer orderid);
}
