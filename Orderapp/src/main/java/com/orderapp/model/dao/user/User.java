package com.orderapp.model.dao.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="user_table")
public class User {
	//AUTO GENERATED USER ID
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	private String password;
	private String email;
	private String shippingAddress;
	private String phoneNumber;
	
	//CONSTRUCTOR FOR CREATING USER
	public User(String username, String password, String email, String shippingAddress, String phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.shippingAddress = shippingAddress;
		this.phoneNumber = phoneNumber;
	}
	
	
}
