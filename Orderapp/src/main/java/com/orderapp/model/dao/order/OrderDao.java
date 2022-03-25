package com.orderapp.model.dao.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{
	/*
	 * @Query for printing all orders associated with particular user
	 */
	@Query(value = "select * from order_table o where o.user_id=?1", 
			  nativeQuery = true)
	public List<Order> getOrderByUser(Integer id);
	
	
	/*
	 * Update status of product from new to in processing if order is placed 24 hours ago 
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update order_table set status='In Processing' where status='NEW' and ordered_on+interval'44 second' < now()", 
			  nativeQuery = true)
	public void updateStatus();
	
	
	/*
	 * Getting all the orders associated with a particular user and which are not deleted
	 */
	@Query(value="select * from order_table where status<> 'DELETED' and order_id=?1", 
			  nativeQuery = true)
	public List<Order> findAll(Integer id);
	
	/*
	 * Finding a particular order associated with particular user
	 * @param userid, orderid
	 */
	@Query(value="select * from order_table where user_id=?1 and order_id=?2 and status<> 'DELETED'",nativeQuery = true)
	public Order getOrderByUserId(Integer userid,Integer orderid);
	
}
