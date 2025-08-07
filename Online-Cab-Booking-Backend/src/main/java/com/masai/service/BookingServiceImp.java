package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.controller.CabController;
import com.masai.exception.BookingNotFoundException;
import com.masai.exception.CabNotFoundException;
import com.masai.exception.CustomerNotFoundException;
import com.masai.model.Booking;
import com.masai.model.BookingStatus;
import com.masai.model.Cab;
import com.masai.model.Customer;
import com.masai.respository.BookingRepository;
import com.masai.respository.CabRepository;
import com.masai.respository.CustomerRespository;

@Service
public class BookingServiceImp implements BookingService {

    

	private BookingRepository bookingRepo;
	private CustomerRespository customerRepo;
	private CabRepository cabRepo;
	

	


	 public BookingServiceImp(BookingRepository bookingrepo, CustomerRespository customerRepo, CabRepository cabRepo) {
		super();
		this.bookingRepo = bookingrepo;
		this.customerRepo = customerRepo;
		this.cabRepo = cabRepo;
	}





	 @Override
	    public Booking createBooking(Booking booking, Integer userId, Integer cabId) {
	        Customer customer = customerRepo.findById(userId)
	                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + userId));

	        Cab cab = cabRepo.findById(cabId)
	                .orElseThrow(() -> new CabNotFoundException("Cab not found with ID: " + cabId));

	        booking.setCustomer(customer);
	        booking.setCabs(cab);
	        booking.setStatus(BookingStatus.CONFIRMED);
	        booking.setDateTime(LocalDateTime.now());

	        // Calculate total amount
	        booking.setTotalAmount(cab.getPerKmRate() * booking.getDistance());

	        return bookingRepo.save(booking);
	    }



 
	 @Override
	    public List<Booking> getAllBookings() {
	        return bookingRepo.findAll();
	    }

	    @Override
	    public Booking getBookingById(Integer id) {
	        return bookingRepo.findById(id)
	                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + id));
	    }

	    @Override
	    public Booking updateBooking(Integer id, Booking updated) {
	        Booking existing = getBookingById(id);

	        existing.setSource(updated.getSource());
	        existing.setDestination(updated.getDestination());
	        existing.setDistance(updated.getDistance());
	        existing.setStatus(updated.getStatus());

	        // Recalculate total
	        existing.setTotalAmount(existing.getCabs().getPerKmRate() * updated.getDistance());

	        return bookingRepo.save(existing);
	    }

	    @Override
	    public void deleteBooking(Integer id) {
	        Booking booking = getBookingById(id);
	        bookingRepo.delete(booking);
	    }

	    @Override
	    public List<Booking> getBookingsByCustomerId(Integer customerId) {
	        return bookingRepo.getBookingsByCustomerId(customerId);
	    }


}
