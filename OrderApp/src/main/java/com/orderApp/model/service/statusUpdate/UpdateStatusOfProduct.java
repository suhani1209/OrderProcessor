package com.orderApp.model.service.statusUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.orderApp.model.dao.order.OrderDao;

@Component
public class UpdateStatusOfProduct {
	private OrderDao orderDao;
	
	@Autowired
	public UpdateStatusOfProduct(OrderDao orderDao)
	{
		this.orderDao=orderDao;
	}
	
	@Scheduled(cron="0 0 0/1 * * *")
	public void changeStatus()
	{
		System.out.println("**updating status");
		orderDao.updateStatus();
	}
}