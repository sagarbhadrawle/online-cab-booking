package com.masai.service;

import java.util.List;

import com.masai.model.Booking;
import com.masai.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public String cancelBooking(Integer bookingId);
	
	public Booking viewBooking(Integer bookingId);
	
	public Booking updateBooking(Integer bookingId, Booking updatedBooking);

	public List<Booking> getBookingHistory(Integer customerId);
	
	public Customer getCustomerByID(String email);
	
}
