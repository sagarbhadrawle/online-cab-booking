package com.masai.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masai.exception.CustomerNotFoundException;
import com.masai.model.Booking;
import com.masai.model.Customer;
import com.masai.respository.BookingRepository;
import com.masai.respository.CustomerRespository;

@Service
public class BookingServiceImp implements BookingService {

	private BookingRepository bookrepo;
	private CustomerRespository customerRepo;
	
	
	
	
	public BookingServiceImp(BookingRepository bookrepo, CustomerRespository customerRepo) {
		super();
		this.bookrepo = bookrepo;
		this.customerRepo = customerRepo;
	}




	@Override
	public Booking createBooking(Booking book, Integer CustomerId) {

		Customer customer = customerRepo.findById(CustomerId)
				.orElseThrow(() -> new CustomerNotFoundException("customer id not present" + CustomerId));
System.out.println(customer);
		book.setCustomer(customer);

		Booking booking = bookrepo.save(book);

		return booking;
	}

}
