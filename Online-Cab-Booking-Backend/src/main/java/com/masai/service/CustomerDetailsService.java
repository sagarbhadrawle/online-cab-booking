package com.masai.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.exception.SomethingWentWrong;
import com.masai.model.Customer;
import com.masai.respository.CustomerRespository;

import lombok.extern.slf4j.Slf4j;


@Service

public class CustomerDetailsService implements UserDetailsService {
	
	private CustomerRespository customerRespository;
	
	
	
	
	public CustomerDetailsService(CustomerRespository customerRespository) {
		super();
		this.customerRespository = customerRespository;
	}




	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		Optional<Customer> customer = customerRespository.findByEmail(email);
		
		return customer.orElseThrow(()-> new SomethingWentWrong("no user found for email "+ email));
	}

}
