package com.orderapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling   //Enable support for scheduling tasks
public class OrderAppApplication{
	public static void main(String[] args) {
		SpringApplication.run(OrderAppApplication.class, args);
	}

}
