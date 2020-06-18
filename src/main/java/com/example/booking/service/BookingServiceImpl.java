package com.example.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking.entity.Customer;
import com.example.booking.repository.BookingDAOImpl;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingDAOImpl bookingDao;
	
	@Override
	public String getHome() {
		return "Home";
	}

	@Override
	public long bookNewCustomer(Customer customer) {
		Customer customerData = bookingDao.save(customer);
		return customerData.getId();
	}

	@Override
	public Customer getCustomerById(long id) {
		Customer customer = bookingDao.findById(id);
		return customer;
	}

}
