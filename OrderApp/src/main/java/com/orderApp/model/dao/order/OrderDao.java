package com.orderApp.model.dao.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{
//	@Query("select * from Order where user=:id")
	@Query(
			  value = "select * from order_table o where o.user_id=?1", 
			  nativeQuery = true)
	public List<Order> getOrderByUser(Integer id);
}