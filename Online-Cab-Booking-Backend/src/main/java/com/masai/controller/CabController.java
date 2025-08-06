package com.masai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.CabDTO;
import com.masai.model.Cab;
import com.masai.service.CabService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CabController {

    private  BookingController bookingController;
	
	private CabService cabService;

	public CabController(CabService cabService, BookingController bookingController) {
		super();
		this.cabService = cabService;
		this.bookingController = bookingController;
	}
	
	@PostMapping("/cabs")
	ResponseEntity<Cab> createCab(@RequestBody  Cab c)
	{  	
//		System.out.println(c);
//		System.out.println(c.getType());
//		System.out.println(c.getPerKmRate());
//		
//		
//		Cab cab = new Cab();
//		cab.setType(c.getType());
//		cab.setPerKmRate(c.getPerKmRate());
//		cab.setIsAvailable(c.getIsAvailable());
		
		Cab cab2 = cabService.addCab(c);
		return new ResponseEntity<>(cab2,HttpStatus.CREATED); 
	}
	
	
	
}
