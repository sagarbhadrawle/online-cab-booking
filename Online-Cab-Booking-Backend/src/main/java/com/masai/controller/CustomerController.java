package com.masai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {
	
	private CustomerService customerService;
	private PasswordEncoder passwordEncoder;
	public CustomerController(CustomerService customerService, PasswordEncoder passwordEncoder) {
		super();
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
}	
