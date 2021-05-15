package com.techjava.productpurchase.services.impl;

import com.techjava.productpurchase.dao.ProductPurchaseJpaDao;
import com.techjava.productpurchase.model.Order;
import com.techjava.productpurchase.services.ProductPurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductPurchaseServiceImpl implements ProductPurchaseService{

    @Autowired
    private ProductPurchaseJpaDao productPurchaseJpaDao;

    @Override
    public Order findOrderByEmail(String email) {
        return productPurchaseJpaDao.findByEmail(email);
    }

   
	@Override
    public Iterable<Order> getAllOrders() {
    	//System.out.println("entered in service");
    	
        return productPurchaseJpaDao.findAll(); //implicit
    }

    //Optional --java8  
    //
    @Override
    public Order findOrderById(Integer orderId) {
        return productPurchaseJpaDao.findById(orderId).get();  //Optional 
    }

    @Override
    public Order updateEmailById(Integer orderId, String email) {
        Order order = productPurchaseJpaDao.findById(orderId).get();
        order.setEmail(email);
        return productPurchaseJpaDao.save(order);
    }

    @Override
    public boolean deleteOrderById(Integer orderId) {
        Order order = productPurchaseJpaDao.findById(orderId).get();
        productPurchaseJpaDao.deleteById(orderId);
        
        if(null == order){
            return true;
        }
        return false;
    }

    @Override
    public Order createOrder(Order order) {
        return productPurchaseJpaDao.save(order);
    }
    @Override
    public List<Order> findByProductName(String pname){
    	List<Order> tlist=productPurchaseJpaDao.findByProductName( pname);
    	return tlist;
    	}
    

	@Override
	public List<Order> getOrderByEmailAndId(String email, Integer orderId) {
		// TODO Auto-generated method stub
		return productPurchaseJpaDao.findByEmailAndId(email, orderId);
	}


	@Override
	public Order getOrderByEmailAndId() {
		// TODO Auto-generated method stub
		return null;
	}


	

    
    
    	
    
}
