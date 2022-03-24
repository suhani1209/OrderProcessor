package com.orderApp.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.orderApp.model.dao.product.Product;
import com.orderApp.model.dao.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	/**FORM BEAN ******USE : UPDATE ORDER
	 **/
	
	private Integer orderId;
	private String status;
	private LocalDateTime orderedOn;
	private User user;
	
	public String getDate(){
		String date=orderedOn.getDayOfMonth()+"-"+orderedOn.getMonthValue()+"-"+orderedOn.getYear();
		return date;
	}
	
	private List<Product> products;
}
