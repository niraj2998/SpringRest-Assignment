package com.techjava.productpurchase.controller;

import com.techjava.productpurchase.dao.ProductPurchaseJpaDao;
import com.techjava.productpurchase.model.Order;
import com.techjava.productpurchase.services.ProductPurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordering")
public class ProductPurchaseController {

    @Autowired
    private ProductPurchaseService productPurchaseService;
    
    @Autowired
    private ProductPurchaseJpaDao productPurchaseJpaDao;

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return (List<Order>) productPurchaseService.getAllOrders();
    }

    @GetMapping("/getOrderById/{orderId}")
    public Order getOrderById(@PathVariable Integer orderId){
        return productPurchaseService.findOrderById(orderId);
    }

    @GetMapping("/getOrderByEmail/{email:.+}")
    public Order getOrderByEmail(@PathVariable String email){
        return productPurchaseService.findOrderByEmail(email);
    }

    
    @GetMapping("/getOrderByProductName/{pname}")
    public List<Order> getOrderByProductName(@PathVariable String pname){
      
        List<Order> tlist=productPurchaseService.findByProductName(pname);
        return tlist;
    }
    @PutMapping("/updateOrderbyId/{email:.+}/order/{orderId}")
    public Order updateOrderById(@PathVariable String email, @PathVariable Integer orderId){
        return productPurchaseService.updateEmailById(orderId, email);
    }
    @GetMapping("/getOrderByEmailandId")
    public List<Order> getOrderByEmailAndId(@RequestParam String email, @RequestParam Integer orderId){
        return productPurchaseJpaDao.findByEmailAndId(email, orderId);
    }
    
/*
 * 
 { 
     "ticketId":"101",
   "passengerName":"Abc",
   "fromStation":"Hyd",
    "toStation":"Chennai",
   "bookingDate":"2019-09-09",
     "email":"abc@gmail.com"
	
	}
 *///,consumes = "application/json", produces = "application/json"
    @PostMapping(path="/createOrder")
    public Order createOrder(@RequestBody Order order){
        return productPurchaseService.createOrder(order);
    }

    @DeleteMapping("/deleteOrderById/order/{orderId}")
    public boolean deleteOrderById(@PathVariable Integer orderId){
        return productPurchaseService.deleteOrderById(orderId);
    }

}
