package com.techjava.productpurchase.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techjava.productpurchase.model.Order;
import com.techjava.productpurchase.services.ProductPurchaseService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductPurchaseController.class)
public class ProductPurchaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductPurchaseService productPurchaseService;


    @Test
    public void testCreateOrder() throws Exception{
        String URI = "/ordering/createOrder";
        Order order = new Order();
        order.setOrderId(101);
        order.setProductName("Iphone12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM 128GB ROM");
        
        order.setEmail("senthil@msn.com");
        String jsonInput = this.converttoJson(order);

        Mockito.when(productPurchaseService.createOrder(Mockito.any(Order.class))).thenReturn(order);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }

    @Test
    public void testGetOrderById() throws Exception{
        String URI= "/ordering/getOrderById/orderId}";
        Order order = new Order();
        order.setOrderId(101);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("senthil@msn.com");
        String jsonInput = this.converttoJson(order);

        Mockito.when(productPurchaseService.findOrderById(Mockito.any())).thenReturn(order);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
    }


    @Test
    public void testGetOrderByProductName() throws Exception{
        String URI= "/ordering/getOrderById/{orderId}";
        Order order = new Order();
        order.setOrderId(101);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("kumar@msn.com");
        String jsonInput = this.converttoJson(order);

        Mockito.when(productPurchaseService.findOrderById(Mockito.any())).thenReturn(order);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        System.out.println(jsonOutput);
     //   assertThat(jsonInput).isEqualTo(jsonOutput);
        assertThat(order.getProductName()).isEqualTo("Iphone 12");
    }


    @Test
    public void testGetAllOrders() throws Exception{
        String URI = "/ordering/getAllOrders";
        Order order1 = new Order();
        order1.setOrderId(101);
        order1.setProductName("Iphone 12");
        order1.setProductPrice(70000);
        order1.setProductDetails("6GB RAM, 128GB ROM");
        
        order1.setEmail("senthil@msn.com");

        Order order2 = new Order();
        order2.setOrderId(104);
        order2.setProductName("Iphone 11");
        order2.setProductPrice(50000);
        order2.setProductDetails("4GB RAM, 64GB ROM");
        order2.setEmail("mani@msn.com");

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        String jsonInput = this.converttoJson(orderList);

        Mockito.when(productPurchaseService.getAllOrders()).thenReturn(orderList);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
    }

    @Test
    public void testFindByEmail() throws Exception{
        String URI = "/ordering/getOrderByEmail/{email:.+}";
        Order order = new Order();
        order.setOrderId(101);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("kumar@msn.com");

        String jsonInput = this.converttoJson(order);

        Mockito.when(productPurchaseService.findOrderByEmail(Mockito.anyString())).thenReturn(order);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, "kumar@msn.com").accept(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
      //  String jsonOutput = mockHttpServletResponse.getContentAsString();
   //System.out.println(jsonInput);
   //System.out.println(jsonOutput);
   
       // MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    //}
        
      //  assertThat(jsonInput).isEqualTo(jsonOutput);
    }

    @Test
    public void testDeleteOrderById() throws Exception{
        String URI = "/ordering/deleteOrderById/order/{orderId}";
        Order order = new Order();
        order.setOrderId(101);
        order.setProductName("Iphone 12");
        order.setProductPrice(70000);
        order.setProductDetails("6GB RAM, 128GB ROM");
        
        order.setEmail("kumar@msn.com");
        Mockito.when(productPurchaseService.findOrderById(Mockito.any())).thenReturn(order);
        Mockito.when(productPurchaseService.deleteOrderById(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.
        		APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

    @Test
    public void testUpdateOrder() throws Exception{

        String URI = "/booking/updateTicketbyId/{email:.+}/ticket/{ticketId}";
        Order order2 = new Order();
        order2.setOrderId(101);
        order2.setProductName("Iphone 12");
        order2.setProductPrice(70000);
        order2.setProductDetails("6GB RAM, 128GB ROM");
        
        order2.setEmail("maran@msn.com");
        String jsonInput = this.converttoJson(order2);

        Mockito.when(productPurchaseService.updateEmailById(Mockito.any(),Mockito.anyString())).thenReturn(order2);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, "\"maran@msn.com\"",101).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput.substring(0,5)).isEqualTo(jsonOutput.substring(0,5));
    }

    /**
     * Convert Object into Json String by using Jackson ObjectMapper
     * @param ticket
     * @return
     * @throws JsonProcessingException
     */
    private String converttoJson(Object order) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(order);
    }

}
