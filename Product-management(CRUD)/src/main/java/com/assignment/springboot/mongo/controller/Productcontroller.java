package com.assignment.springboot.mongo.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.springboot.mongo.model.Product;
import com.assignment.springboot.mongo.service.Productservice;

@RestController
@RequestMapping(value= "/api/mongo/prod")
public class Productcontroller {

	@Autowired
	Productservice serv;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to save employees in the db.
	 * @param emp
	 * @return
	 */
	@PostMapping(value= "/add")
	public String create(@RequestBody List<Product> prod) {
		logger.debug("Saving products.");
		serv.addProduct(prod);
		return "Products added.";
	}

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	@GetMapping(value= "/getall")
	public Collection<Product> getAll() {
		logger.debug("Getting all products.");
		return serv.getAllProduct();
	}

	/**
	 * Method to fetch employee by id.
	 * @param id
	 * @return
	 */
	@GetMapping(value= "/getbyid/{product-id}")
	public Optional<Product> getById(@PathVariable(value= "product-id") int id) {
		logger.debug("Getting product with product-id= {}.", id);
		return serv.findProductById(id);
	}

	/**
	 * Method to update employee by id.
	 * @param id
	 * @param e
	 * @return
	 */
	@PutMapping(value= "/update/{product-id}")
	public String update(@PathVariable(value= "product-id") int id, @RequestBody Product p) {
		logger.debug("Updating product with product-id= {}.", id);
		p.setId(id);
		serv.updateProduct(p);
		return "Product record for product-id= " + id + " updated.";
	}

	/**
	 * Method to delete employee by id.
	 * @param id
	 * @return
	 */
	@DeleteMapping(value= "/delete/{product-id}")
	public String delete(@PathVariable(value= "product-id") int id) {
		logger.debug("Removing product with product-id= {}.", id);
		serv.deleteProductById(id);
		return "Product record for product-id= " + id + " removed.";
	}

	/**
	 * Method to delete all employees from the db.
	 * @return
	 */
	@DeleteMapping(value= "/deleteall")
	public String deleteAll() {
		logger.debug("Removing all products.");
		serv.deleteAllProduct();
		return "All product records deleted.";
	}
}