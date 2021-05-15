package com.techjava.productpurchase.services;

import java.util.List;
import java.util.Optional;

import com.techjava.productpurchase.model.Order;



public interface ProductPurchaseService {

	Order findOrderByEmail(String email);
    Iterable<Order> getAllOrders();
    Order findOrderById(Integer orderId);
    Order updateEmailById(Integer orderId, String email);
    boolean deleteOrderById(Integer orderId);
    Order  createOrder(Order order);
    List<Order> findByProductName(String pname);
	List<Order> getOrderByEmailAndId(String email, Integer orderId);
	Order getOrderByEmailAndId();
    

}
