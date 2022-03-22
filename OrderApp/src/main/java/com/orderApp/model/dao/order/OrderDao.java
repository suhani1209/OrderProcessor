package com.orderApp.model.dao.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{
	@Query(value = "select * from order_table o where o.user_id=?1", 
			  nativeQuery = true)
	public List<Order> getOrderByUser(Integer id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update order_table set status='In Processing' where status='NEW' and ordered_on+interval'44 second' < now()", 
			  nativeQuery = true)
	public void updateStatus();
	
	@Query(value="select * from order_table where status<> 'DELETED' and order_id=?1", 
			  nativeQuery = true)
	public List<Order> findAll(Integer id);
	
}
