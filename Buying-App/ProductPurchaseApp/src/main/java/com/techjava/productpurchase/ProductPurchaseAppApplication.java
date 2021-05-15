package com.techjava.productpurchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductPurchaseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPurchaseAppApplication.class, args);
	}
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}





//swagger
//logback
//git,jenkins
//one tomany association

//custom query
//post request with restTemaplte
//testing