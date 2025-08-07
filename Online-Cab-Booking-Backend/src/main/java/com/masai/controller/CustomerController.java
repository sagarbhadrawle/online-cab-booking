package com.masai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Booking;
import com.masai.model.Customer;
import com.masai.service.BookingService;
import com.masai.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {
	private BookingService bookingService;
	private CustomerService customerService;
	private PasswordEncoder passwordEncoder;
	
	
	
	public CustomerController(BookingService bookingService, CustomerService customerService,
			PasswordEncoder passwordEncoder) {
		super();
		this.bookingService = bookingService;
		this.customerService = customerService;
		this.passwordEncoder = passwordEncoder;
	}




	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer )
	{
		String hashedPassword = passwordEncoder.encode(customer.getPassword());
		
		customer.setPassword(hashedPassword);
		
		Customer cust = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeString()
	{
		return new ResponseEntity<String>("hi baby",HttpStatus.OK);
	}
	
	@DeleteMapping("/cancelBooking/{bookingId}")
	public ResponseEntity<String> cancelBooking(@PathVariable Integer bookingId)
	{
		String cancelBooking = customerService.cancelBooking(bookingId);
		
		
		return new ResponseEntity<String>(cancelBooking,HttpStatus.ACCEPTED);
	}
	

	@GetMapping("/viewBooking/{bookingId}")
	public ResponseEntity<Booking> viewBooking(@PathVariable Integer bookingId)
	{	
		Booking viewBooking = customerService.viewBooking(bookingId);
		
		return new ResponseEntity<Booking>(viewBooking,HttpStatus.OK);
	}
	
	@PutMapping("/updateBooking/{bookingId}")
	public ResponseEntity<Booking> updateBooking(@PathVariable Integer bookingId, @RequestBody Booking updatedBooking) {
		
	    Booking updated = customerService.updateBooking(bookingId, updatedBooking);
	    
	    return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@GetMapping("/bookingHistory/{customerId}")
	public ResponseEntity<List<Booking>> getBookingHistory(@PathVariable Integer customerId) {
		
	    List<Booking> history = customerService.getBookingHistory(customerId);
	    
	    return new ResponseEntity<>(history, HttpStatus.OK);
	}
	
		
	
}	
