package com.techjava.productpurchase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techjava.productpurchase.model.Order;

@Repository
public interface ProductPurchaseJpaDao extends JpaRepository<Order,Integer>{
	

	
	@Query("select o from Order o where o.email=:email")
    Order findByEmail( String email);
    
    
    @Query("select o from Order o where o.productName=:pname")
    List<Order> findByProductName(String pname);
    
    
    @Query("select o from Order o where o.email = :email and o.orderId = :orderId")
	List<Order> findByEmailAndId(@Param("email") String email,@Param("orderId") Integer orderId);
    

}
