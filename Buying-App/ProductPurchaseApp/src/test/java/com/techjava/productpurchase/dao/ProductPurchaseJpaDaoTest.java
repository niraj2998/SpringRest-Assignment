package com.techjava.productpurchase.dao;

import com.techjava.productpurchase.dao.ProductPurchaseJpaDao;
import com.techjava.productpurchase.model.Order;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest // jpa test case 
public class ProductPurchaseJpaDaoTest {

    @Autowired
    private ProductPurchaseJpaDao productPurchaseJpaDao;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testNewOrder() throws Exception{
        Order order = getOrder();
        Order saveInDb = testEntityManager.persist(order);
        Order getFromInDb = productPurchaseJpaDao.findById(saveInDb.getOrderId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
    }

    @Test
    public void testGetOrderById() throws Exception{
        Order order = new Order();
        order.setOrderId(101);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("kumar@msn.com");

        //Insert Data into in memory database
        Order saveInDb = testEntityManager.persist(order);
        //Get Data from DB
        Order getInDb = productPurchaseJpaDao.findById(order.getOrderId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
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

        //Save into in memory database
        testEntityManager.persist(order1);
        testEntityManager.persist(order2);

        //Retrieve all tickets
        List<Order> orderList = (List<Order>) productPurchaseJpaDao.findAll();

        Assert.assertEquals(2, orderList.size());
    }

    @Test
    public void testFindByEmail() throws Exception{
        Order order = new Order();
        order.setOrderId(101);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("kumar@msn.com");

        Order saveInDb = testEntityManager.persist(order);
        Order getInDb = productPurchaseJpaDao.findByEmail(saveInDb.getEmail());

        Assert.assertEquals(saveInDb.getEmail(), getInDb.getEmail());
    }

    @Test
    public void testDeleteOrderById() throws Exception{
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


        Order order = testEntityManager.persist(order1);
        testEntityManager.persist(order2);

        //delete one ticket DB
        testEntityManager.remove(order);

        List<Order> orders = (List<Order>) productPurchaseJpaDao.findAll();
        Assert.assertEquals(orders.size(), 1);

    }

    @Test
    public void testUpdateOrder(){

    	 Order order2 = new Order();
         order2.setOrderId(104);
         order2.setProductName("Iphone X");
         order2.setProductPrice(40000);
         order2.setProductDetails("6GB RAM, 128GB ROM");
         
         order2.setEmail("azeem@msn.com");


        testEntityManager.persist(order2);

        Order getFromDb = productPurchaseJpaDao.findByEmail("azeem@msn.com");
        getFromDb.setEmail("azeem11@msn.com");
        testEntityManager.persist(getFromDb);

        assertThat(getFromDb.getEmail()).isEqualTo("azeem11@msn.com");
    }


    private Order getOrder() {
        Order order = new Order();
        order.setOrderId(101);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("kumar@msn.com");;
        return order;
    }
}
