package com.orderApp.model.dao.order;

import java.time.LocalDateTime;
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
	private LocalDateTime orderedOn;
	
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
		this.orderedOn = LocalDateTime.now();
		this.products = products;
	}
	
	public String getDate(){
		String date=orderedOn.getDayOfMonth()+"-"+orderedOn.getMonthValue()+"-"+orderedOn.getYear();
		return date;
	}
	
	public String getTime() {
		String time=orderedOn.getHour()+":"+orderedOn.getMinute()+":"+orderedOn.getSecond();
		return time;
	}
	
}
