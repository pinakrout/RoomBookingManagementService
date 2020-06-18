package com.example.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking.entity.Customer;
import com.example.booking.service.BookingService;

@RestController
public class BookingController {


	@Autowired 
	BookingService bookingService;

	private HttpStatus httpStatus;


	@GetMapping("/api/customer/home")
	public String getHome() {
		return bookingService.getHome();
	}


	@PostMapping("/api/customer") 
	public ResponseEntity<Long> bookNewCustomer(@RequestBody Customer customer) { 
		long customerId =
				bookingService.bookNewCustomer(customer); if(customerId == 0) httpStatus =
				HttpStatus.CREATED; else httpStatus = HttpStatus.BAD_REQUEST; return new
						ResponseEntity<>(customerId , httpStatus); }

	@GetMapping("/api/customer/{id}") 
	public ResponseEntity<Customer> getCustomerById(@PathVariable(name="id") long id) { 
		Customer customer =
				bookingService.getCustomerById(id); if(customer != null) httpStatus =
				HttpStatus.OK; else httpStatus = HttpStatus.NOT_FOUND; return new
						ResponseEntity<>(customer , httpStatus); }

}
