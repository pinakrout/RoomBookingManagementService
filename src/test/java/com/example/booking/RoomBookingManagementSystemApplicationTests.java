package com.example.booking;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.booking.controller.BookingController;
import com.example.booking.entity.Customer;
import com.example.booking.repository.BookingDAOImpl;
import com.example.booking.service.BookingService;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

@SpringBootTest
public class RoomBookingManagementSystemApplicationTests {

	@Autowired
	private BookingService bookingService;

	@MockBean
	private BookingDAOImpl bookingDao;


	@Test
	public void testGetHome() throws Exception {
		assertEquals("Home", bookingService.getHome());
	}
	
	@Test
    @DisplayName("Test getCustomerById Success")
    void testFindById() {
        // Setup our mock repository
        Customer customer = new Customer(1, "Pinak", "Rout", null, "pinakrout217@gmail.com", "abc");
        doReturn(customer).when(bookingDao).findById(1l);

        // Execute the service call
        Customer returnedCustomer = bookingService.getCustomerById(1l);

        // Assert the response
        assertNotNull(returnedCustomer);
        assertEquals(customer, returnedCustomer);
    }

}
