package com.example.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.Customer;

@Repository
public interface BookingDAOImpl extends JpaRepository<Customer, Long> {
	@SuppressWarnings("unchecked")
	public Customer save(Customer customer);
	public Customer findById(long id);
}
