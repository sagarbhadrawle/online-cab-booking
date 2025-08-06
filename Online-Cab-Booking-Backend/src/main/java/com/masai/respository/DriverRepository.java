package com.masai.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
