package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.model.Customer;
import com.masai.respository.CustomerRespository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRespository customerRespo;

	public CustomerServiceImpl(CustomerRespository customerRespo) {
		super();
		this.customerRespo = customerRespo;
	}

	@Override
	public Customer addCustomer(Customer customer) {

		Customer save = customerRespo.save(customer);

		return save;

	}

}
