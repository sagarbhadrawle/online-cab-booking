package com.masai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerNotFoundException;
import com.masai.model.Booking;
import com.masai.model.Customer;
import com.masai.respository.CustomerRespository;
import com.masai.service.BookingService;

@RestController

public class BookingController {
	
	private BookingService bookingService;
	private CustomerRespository customerRepo;
	

	
	
	
	public BookingController(BookingService bookingService, CustomerRespository customerRepo) {
		super();
		this.bookingService = bookingService;
		this.customerRepo = customerRepo;
	}





	@PostMapping("/booking/{userId}")
	ResponseEntity<Booking> createBooking(@RequestBody Booking booking , @PathVariable Integer userId)
	{
		
		
		Booking booking2 = bookingService.createBooking(booking,userId);
		
		return new ResponseEntity<Booking>(booking2,HttpStatus.CREATED);
	}
	
	
	
}
