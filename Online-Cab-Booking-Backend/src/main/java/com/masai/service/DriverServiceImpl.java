package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.DriverNotFoundException;
import com.masai.model.Driver;
import com.masai.respository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	private DriverRepository driverRepo;

	public DriverServiceImpl(DriverRepository driverRepo) {
		super();
		this.driverRepo = driverRepo;
	}

	
	
	
	   @Override
	    public Driver addDriver(Driver driver) {
	        return driverRepo.save(driver);
	    }

	    @Override
	    public List<Driver> getAllDrivers() {
	        return driverRepo.findAll();
	    }

	    @Override
	    public Driver getDriverById(Integer id) {
	        return driverRepo.findById(id)
	                .orElseThrow(() -> new DriverNotFoundException("Driver not found with ID: " + id));
	    }

	    @Override
	    public Driver updateDriver(Integer id, Driver updatedDriver) {
	        Driver existing = getDriverById(id);

	        existing.setName(updatedDriver.getName());
	        existing.setMob(updatedDriver.getMob());
	        existing.setAvailability(updatedDriver.getAvailability());
	        

	        return driverRepo.save(existing);
	    }

	    @Override
	    public void deleteDriver(Integer id) {
	        Driver driver = getDriverById(id);
	        driverRepo.delete(driver);
	    }

	    @Override
	    public Driver toggleAvailability(Integer id) {
	        Driver driver = getDriverById(id);
	        driver.setAvailability(!driver.getAvailability());
	        return driverRepo.save(driver);
	    }
	
}
