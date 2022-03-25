package com.orderapp.model.dao.order;

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

import com.orderapp.model.dao.product.Product;
import com.orderapp.model.dao.user.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  
@Data
@NoArgsConstructor
@Table(name="order_table")  //NAME THIS TABLE AS order_table IN DATABASE
public class Order {
	
	/**AUTO GENERATED 
	 * ORDER ID**/
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	/**ORDER STATUS
	 * CAN BE : 'NEW', 'In Processing', 'DELETED'
	 **/
	private String status;
	
	//DATE TIME AT WHICH ORDER IS PLACED 
	private LocalDateTime orderedOn;
	
	/**MAPPING OF USER AND ORDER 
	 * MANY TO ONE
	 *MANY ORDERS CAN HAVE ONE USER
	 **/
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;
	
	/**MAPPING OF PRODUCT AND ORDER : MANY TO MANY 
	 *MANY ORDERS CAN HAVE MANY PRODUCTS
	 **/
	@ManyToMany(targetEntity=Product.class, cascade={CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name="ORDER_PRODUCTS", 
            joinColumns=   { @JoinColumn(name="orderId") },
            inverseJoinColumns= { @JoinColumn(name="productId")} )
	
	private List<Product> products;

	/**CONSTRUCTOR FOR CREATING NEW ORDER 
	 * INPUT PARAMETER: LIST OF PRODUCTS
	 * */
	public Order(List<Product> products) {
		this.status = "NEW";
		this.orderedOn = LocalDateTime.now();
		this.products = products;
	}
	
	//METHOD FOR GETTING DATE ON WHICH ORDER IS PLACED
	public String getDate(){
		return orderedOn.getDayOfMonth()+"-"+orderedOn.getMonthValue()+"-"+orderedOn.getYear();
	}
	
	//METHOD FOR GETTING TIME AT WHICH ORDER IS PLACED 
	public String getTime() {
		return orderedOn.getHour()+":"+orderedOn.getMinute()+":"+orderedOn.getSecond();
		
	}
	
}
