package com.orderapp.model.service.statusUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.orderapp.model.dao.order.OrderDao;

@Component
public class UpdateStatusOfProduct {
	private OrderDao orderDao;
	
	@Autowired
	public UpdateStatusOfProduct(OrderDao orderDao)
	{
		this.orderDao=orderDao;
	}
	
	/**SCHEDULED JOB RUNS EVERY HOUR AND 
	 * UPDATING THE STATUS OF NEW ORDERS PLACED BEFORE 24 HOURS 
	 * @SCHEDULED : this annotation is used to configure and schedule task
	 **/
	@Scheduled(cron="0 0 0/1 * * *")
	public void changeStatus()
	{
		orderDao.updateStatus();
	}
}
