package com.masai.service;

import java.util.List;

import com.masai.model.Booking;

public interface BookingService {

	public Booking createBooking(Booking book, Integer CustomerId, Integer CabId);

	List<Booking> getAllBookings();

	Booking getBookingById(Integer id);

	Booking updateBooking(Integer id, Booking booking);

	void deleteBooking(Integer id);

	List<Booking> getBookingsByCustomerId(Integer customerId);
}
