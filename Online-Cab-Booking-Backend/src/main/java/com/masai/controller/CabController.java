package com.masai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Cab;
import com.masai.service.CabService;

@RestController
@CrossOrigin("*")
public class CabController {

	private CabService cabService;

	public CabController(CabService cabService) {
		super();
		this.cabService = cabService;
	}

	@PostMapping("/cabs/{driverId}")
	ResponseEntity<Cab> createCab(@RequestBody Cab c, @PathVariable Integer driverId) {
		Cab cab2 = cabService.addCab(c, driverId);
		return new ResponseEntity<>(cab2, HttpStatus.CREATED);
	}

	@GetMapping("/cabs")
	public ResponseEntity<List<Cab>> getAllCabs() {
		return new ResponseEntity<>(cabService.getAllCabs(), HttpStatus.OK);
	}

	@GetMapping("/cabs/{id}")
	public ResponseEntity<Cab> getCabById(@PathVariable Integer id) {
		return new ResponseEntity<>(cabService.getCabById(id), HttpStatus.OK);
	}

	@PutMapping("/cabs/{id}")
	public ResponseEntity<Cab> updateCab(@PathVariable Integer id, @RequestBody Cab cab) {
		return new ResponseEntity<>(cabService.updateCab(id, cab), HttpStatus.OK);
	}

	@DeleteMapping("/cabs/{id}")
	public ResponseEntity<String> deleteCab(@PathVariable Integer id) {
		cabService.deleteCab(id);
		return new ResponseEntity<>("Cab deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/cabs/available")
	public ResponseEntity<List<Cab>> getAvailableCabs() {
		return new ResponseEntity<>(cabService.getAvailableCabs(), HttpStatus.OK);
	}

}
