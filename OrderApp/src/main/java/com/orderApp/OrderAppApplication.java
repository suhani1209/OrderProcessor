package com.orderApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling   /********ENABLE SUPPORT FOR SCHEDULING TASKS*****************************/
public class OrderAppApplication{

	
	public static void main(String[] args) {
		SpringApplication.run(OrderAppApplication.class, args);
	}

}
