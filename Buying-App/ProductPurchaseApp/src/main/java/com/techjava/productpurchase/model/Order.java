package com.techjava.productpurchase.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order123")
public class Order {

    
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDetails=" + productDetails + ", email=" + email + "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "product_price", nullable = false)
    private Integer productPrice;
    @Column(name = "product_details", nullable = false)
    private String productDetails;
    @Column(name = "email", unique = true)
    private String email;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

   
}
