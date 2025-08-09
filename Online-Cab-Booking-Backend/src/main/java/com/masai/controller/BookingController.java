package com.masai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Booking;
import com.masai.service.BookingService;

@RestController

public class BookingController {
	
	private BookingService bookingService;
	
	

	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}


	@PostMapping("/booking/{userId}/{cabId}")
	ResponseEntity<Booking> createBooking(@RequestBody Booking booking , @PathVariable Integer userId,@PathVariable Integer cabId)
	{
		
		
		Booking booking2 = bookingService.createBooking(booking,userId,cabId);
		
		return new ResponseEntity<Booking>(booking2,HttpStatus.CREATED);
	}
	
	@GetMapping("/booking")
	public ResponseEntity<List<Booking>> getAllBookings() {
		
	    return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
	}

	@GetMapping("/booking/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Integer id) {
		
	    return new ResponseEntity<>(bookingService.getBookingById(id), HttpStatus.OK);
	}

	@PutMapping("/booking/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable Integer id, @RequestBody Booking booking) {
		
	    return new ResponseEntity<>(bookingService.updateBooking(id, booking), HttpStatus.OK);
	}

	@DeleteMapping("/booking/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable Integer id) {
		
	    bookingService.deleteBooking(id);
	    
	    return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/findBookingUsingCustomer/{customerId}")
	public ResponseEntity<List<Booking>> getBookingsByCustomer(@PathVariable Integer customerId) {
		
	    return new ResponseEntity<>(bookingService.getBookingsByCustomerId(customerId), HttpStatus.OK);
	}

	
	
}
