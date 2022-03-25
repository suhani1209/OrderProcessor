package com.orderapp.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.orderapp.model.dao.product.Product;
import com.orderapp.model.dao.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	/**FORM BEAN 
	  * USE : UPDATE ORDER
	 **/
	
	private Integer orderId;
	private String status;
	private LocalDateTime orderedOn;
	private User user;
	
	public String getDate(){
		return orderedOn.getDayOfMonth()+"-"+orderedOn.getMonthValue()+"-"+orderedOn.getYear();
	}
	
	private List<Product> products;
}
