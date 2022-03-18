package com.orderApp.model.dao.order;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.orderApp.model.dao.product.Product;
import com.orderApp.model.dao.user.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="order_table")
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private String status;
	private LocalDate orderedOn;
	private LocalTime orderTime;
	
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;
	
	@ManyToMany(targetEntity=Product.class, cascade={CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name="ORDER_PRODUCTS", 
            joinColumns=   { @JoinColumn(name="orderId") },
            inverseJoinColumns= { @JoinColumn(name="productId")} )
	
	private List<Product> products;

	public Order(List<Product> products) {
		this.status = "NEW";
		this.orderedOn = LocalDate.now();
		this.orderTime=LocalTime.now();
		this.products = products;
	}
	
	
}