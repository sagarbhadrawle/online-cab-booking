package com.masai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Driver;
import com.masai.service.DriverService;

@RestController
@CrossOrigin("*")
public class DriverController {
	
	
	private DriverService driverService;

	public DriverController(DriverService driverService) {
		super();
		this.driverService = driverService;
	}
	
	@PostMapping("/drivers")
	ResponseEntity<Driver> createDriver(@RequestBody Driver driver)
	{	
		System.out.println(driver.getName());
		
		Driver driver2 = driverService.addDriver(driver);
		
		return new ResponseEntity<>(driver2, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/drivers")
	public ResponseEntity<List<Driver>> getAllDrivers() {
		
	    List<Driver> drivers = driverService.getAllDrivers();
	    
	    return new ResponseEntity<>(drivers, HttpStatus.OK);
	}

	
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> getDriverById(@PathVariable Integer id) {
		
	    Driver driver = driverService.getDriverById(id);
	    
	    return new ResponseEntity<>(driver, HttpStatus.OK);
	}


	@PutMapping("/drivers/{id}")
	public ResponseEntity<Driver> updateDriver(@PathVariable Integer id, @RequestBody Driver driver) {
		
	    Driver updatedDriver = driverService.updateDriver(id, driver);
	    
	    return new ResponseEntity<>(updatedDriver, HttpStatus.OK);
	}

	
	@DeleteMapping("/drivers/{id}")
	public ResponseEntity<String> deleteDriver(@PathVariable Integer id) {
		
	    driverService.deleteDriver(id);
	    
	    return new ResponseEntity<>("Driver deleted successfully", HttpStatus.OK);
	}
	
	@PatchMapping("/drivers/{id}/availability")
	public ResponseEntity<Driver> toggleAvailability(@PathVariable Integer id) {
		
	    Driver updatedDriver = driverService.toggleAvailability(id);
	    
	    return new ResponseEntity<>(updatedDriver, HttpStatus.OK);
	}

	
}
