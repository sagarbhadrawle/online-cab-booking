package com.masai.service;

import java.util.List;

import com.masai.model.Driver;

public interface DriverService {
	
	 Driver addDriver(Driver driver);
	
	 List<Driver> getAllDrivers();

	 Driver getDriverById(Integer id);

	 Driver updateDriver(Integer id, Driver driver);

	 void deleteDriver(Integer id);

	 Driver toggleAvailability(Integer id);
}
