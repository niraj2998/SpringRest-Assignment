package com.example.springbootapi;

import java.util.ArrayList;
import java.util.List;

public class AddressRepository 
{
	List<Address> address;
	
	
	public AddressRepository() {
		address =new ArrayList<>();
		Address ad= new Address();
		ad.setCity("kolkata");
		ad.setCountry("India");
		ad.setState("West Bengal");
		ad.setZip(99502);
		
		
		Address ad2= new Address();
		ad2.setCity("Howrah");
		ad2.setCountry("India");
		ad2.setState("West Bengal");
		ad2.setZip(99503);
		
		Address ad3= new Address();
		ad3.setCity("Mumbai");
		ad3.setCountry("India");
		ad3.setState("Maharashtra");
		ad3.setZip(99500);
		
		
		Address ad4= new Address();
		ad4.setCity("ANCHORAGE");
		ad4.setCountry("US");
		ad4.setState("AK");
		ad4.setZip(99501);
		address.add(ad);
		address.add(ad2);
		address.add(ad3);
		address.add(ad4);
		
}
	public List<Address> getAddress(){
		
		return address;
	}
public Address getAddress(int zip) {
	
	
	for(Address a:address)
	{
		if(a.getZip()==zip)
			return a;
		
	}
	return null;
	
}
	
	
}