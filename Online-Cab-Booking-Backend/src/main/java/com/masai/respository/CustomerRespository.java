package com.masai.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;
@Repository
public interface CustomerRespository extends JpaRepository<Customer, Integer> {

public	Optional<Customer> findByEmail(String email);  // select c from customer c where c.email = :email
	
Optional<Customer> findById(Integer customerid);
	
}	
