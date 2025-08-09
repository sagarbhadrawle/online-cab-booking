package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masai.exception.BookingNotFoundException;
import com.masai.exception.CustomerNotFoundException;
import com.masai.exception.SomethingWentWrong;
import com.masai.model.Booking;
import com.masai.model.Customer;
import com.masai.respository.BookingRepository;
import com.masai.respository.CustomerRespository;

@Service
public class CustomerServiceImpl implements CustomerService {
	private BookingRepository bookrepo;
	private CustomerRespository customerRespo;
	private BookingRepository bookingRespo;

	public CustomerServiceImpl(BookingRepository bookrepo, CustomerRespository customerRespo,
			BookingRepository bookingRespo) {
		super();
		this.bookrepo = bookrepo;
		this.customerRespo = customerRespo;
		this.bookingRespo = bookingRespo;
	}

	@Override
	public Customer addCustomer(Customer customer) {

		Customer save = customerRespo.save(customer);

		return save;

	}

	@Override
	public String cancelBooking(Integer bookingId) {

		Optional<Booking> byId = bookrepo.findById(bookingId);

		if (byId.isPresent()) {
			bookrepo.delete(byId.get());
			return "deleted Successfully";

		} else {
			throw new SomethingWentWrong("no booking with given id" + bookingId);
		}

	}

	@Override
	public Booking viewBooking(Integer bookingId) {

		Optional<Booking> booking = bookrepo.findById(bookingId);

		if (booking.isPresent()) {
			return booking.get();
		}

		throw new BookingNotFoundException("No booking with given id" + bookingId);
	}

	@Override
	public Booking updateBooking(Integer bookingId, Booking updatedBooking) {
		
		 Optional<Booking> optional = bookrepo.findById(bookingId);

		    if (optional.isEmpty()) {
		        throw new BookingNotFoundException("No booking found with id: " + bookingId);
		    }

		    Booking existing = optional.get();

		    // Update fields
		    existing.setSource(updatedBooking.getSource());
		    existing.setDestination(updatedBooking.getDestination());
		    existing.setDistance(updatedBooking.getDistance());
		    existing.setStatus(updatedBooking.getStatus());
		    existing.setTotalAmount(updatedBooking.getTotalAmount());
		    

		    return bookrepo.save(existing);
		
	}

	@Override
	public List<Booking> getBookingHistory(Integer customerId) {
		Optional<Customer> customerOpt = customerRespo.findById(customerId);
	    
	    if (customerOpt.isEmpty()) {
	        throw new SomethingWentWrong("Customer with id " + customerId + " not found.");
	    }

	    return bookrepo.getBookingsByCustomerId(customerId);
	}

	@Override
	public Customer getCustomerByID(String email) {
		
		Optional<Customer> byEmail = customerRespo.findByEmail(email);

		if(byEmail.isPresent())
		{
			return  byEmail.get();
		}
		 
		throw new CustomerNotFoundException("No customer with given email id "+email);
	}

}
