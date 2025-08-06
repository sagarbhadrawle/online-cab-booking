package com.masai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Cab;
import com.masai.service.CabService;



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

		
		Cab cab2 = cabService.addCab(c);
		return new ResponseEntity<>(cab2,HttpStatus.CREATED); 
	}
	
	
	
}
