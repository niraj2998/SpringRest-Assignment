package com.example.springbootapi;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("address")
public class AddressResource {
	AddressRepository repo=new AddressRepository();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Address> getAddress() 
	{
       return repo.getAddress();
	}
	
	
	     
	@GET
	@Path("address1/{zip}")
	@Produces(MediaType.APPLICATION_JSON)
	public  Address getAddress1(@PathParam("zip") int zip)
	{
		return repo.getAddress(zip);
		
	}
	

}
