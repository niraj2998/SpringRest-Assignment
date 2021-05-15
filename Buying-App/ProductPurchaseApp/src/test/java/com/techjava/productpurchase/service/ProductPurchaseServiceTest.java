package com.techjava.productpurchase.service;


import com.techjava.productpurchase.dao.ProductPurchaseJpaDao;
import com.techjava.productpurchase.model.Order;
import com.techjava.productpurchase.services.ProductPurchaseService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductPurchaseServiceTest {

    @MockBean
    private ProductPurchaseJpaDao productPurchaseJpaDao;

    @Autowired
    private ProductPurchaseService productPurchaseService;

    @Test
    public void testCreateOrder(){
        Order order = new Order();
        order.setOrderId(101);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("kumar@msn.com");

        Mockito.when(productPurchaseJpaDao.save(order)).thenReturn(order);
        
        
        assertThat(productPurchaseService.createOrder(order)).isEqualTo(order);
    }

    @Test
    public void testGetOrderById() throws Exception{
        Order order = new Order();
        order.setOrderId(100);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("kumar@msn.com");
Order tt=productPurchaseJpaDao.findById(100).get();
        Mockito.when(tt).thenReturn(order);
        assertThat(productPurchaseService.findOrderById(100)).isEqualTo(order);
    }

    @Test
    public void testGetAllOrders() throws Exception{
    	Order order1 = new Order();
        order1.setOrderId(101);
        order1.setProductName("Iphone 12");
        order1.setProductPrice(70000);
        order1.setProductDetails("6GB RAM, 128GB ROM");
        
        order1.setEmail("kumar@msn.com");

        Order order2 = new Order();
        order2.setOrderId(104);
        order2.setProductName("Iphone X");
        order2.setProductPrice(40000);
        order2.setProductDetails("6GB RAM, 128GB ROM");
        
        order2.setEmail("azeem@msn.com");

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        Mockito.when(productPurchaseJpaDao.findAll()).thenReturn(orderList);
        assertThat(productPurchaseService.getAllOrders()).isEqualTo(orderList);
    }


    @Test
    public void testFindByEmail() throws Exception{
        Order order = new Order();
        order.setOrderId(101);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("kumar@msn.com");

        Mockito.when(productPurchaseJpaDao.findByEmail("kumar@msn.com")).thenReturn(order);
        assertThat(productPurchaseService.findOrderByEmail("kumar@msn.com")).isEqualTo(order);
    }

    @Test
    public void testDeleteOrderById() throws Exception{
    	Order order = new Order();
        order.setOrderId(105);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("kumar@msn.com");;

        Mockito.when(productPurchaseJpaDao.save(order)).thenReturn(order);
        Mockito.when(productPurchaseJpaDao.findById(105).get()).thenReturn(order);
        productPurchaseJpaDao.deleteById(order.getOrderId());
        Mockito.when(productPurchaseJpaDao.findById(105).get()).thenReturn(order);
        Assert.assertNotEquals(order, new Order());
        Assert.assertEquals(productPurchaseService.deleteOrderById(105), false);
    }

    @Test
    public void testDeleteOrderByNull() throws Exception{
        Order order = new Order();
        order.setOrderId(1005);
        Order nullTicket = null;
        Mockito.when(productPurchaseJpaDao.findById(1005).get()).thenReturn(nullTicket);
        productPurchaseJpaDao.deleteById(order.getOrderId());
        Assert.assertEquals(productPurchaseService.deleteOrderById(1005), true);
    }

    @Test
    public void testUpdateOrder() throws Exception{

    	 Order order2 = new Order();
         order2.setOrderId(100);
         order2.setProductName("Iphone X");
         order2.setProductPrice(40000);
         order2.setProductDetails("6GB RAM, 128GB ROM");
         
         order2.setEmail("azeem@msn.com");
        productPurchaseJpaDao.save(order2);
        Mockito.when(productPurchaseJpaDao.findById(100).get()).thenReturn(order2);
        order2.setEmail("azeem100@msn.com");
        Mockito.when(productPurchaseJpaDao.save(order2)).thenReturn(order2);
        System.out.println(order2.getEmail());
        assertThat(productPurchaseService.updateEmailById(100, "azeem100@msn.com")).isEqualTo(order2);
    }

}
