package com.techjava.productpurchase;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techjava.productpurchase.model.Order;

public class ProductPurchaseRestClient {
	   @Autowired
	   RestTemplate restTemplate;
	   public void getOrderDetails() {
		
	final String uri = "http://localhost:8085/booking/getTicketById/32";
    RestTemplate restTemplate = new RestTemplate();
     HttpHeaders headers = new HttpHeaders();
   HttpEntity <Order> entity = new HttpEntity<Order>(headers);
    
    // ResponseEntity<Ticket> response = restTemplate.getForEntity(uri, Ticket.class);
    Order order=new Order();
  //  order.setOrderId(10);
    order.setEmail("azeem@gmail.com");
  //  order.setBookingDate(new Date());
    order.setProductName("Iphone 12");
    order.setProductPrice(70000);
    order.setProductDetails("4GB RAM, 64GB ROM");
    
   ResponseEntity<Order> response = restTemplate.postForEntity("http://localhost:8085/booking/createOrder",order, Order.class);
    
   System.out.println(response.getBody().toString());
   
   //System.out.println(restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody().toString());
   
   
   //System.out.println( restTemplate.exchange("http://localhost:8085/booking/createTicket", HttpMethod.POST, entity, String.class).getBody());
   //restTemplate.exchange("http://localhost:8085/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
   //restTemplate.exchange("http://localhost:8085/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
   
	}
	public static void main(String[] args) {
		ProductPurchaseRestClient client= new ProductPurchaseRestClient();
		client.getOrderDetails();
	}
}
