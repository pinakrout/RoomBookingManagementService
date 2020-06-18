package com.example.booking.service;

import com.example.booking.entity.Customer;

public interface BookingService {
	
	public long bookNewCustomer(Customer customer); 
	
	public String getHome();
	
	public Customer getCustomerById(long id); 
}
