package com.masai.service;

import java.util.List;

import com.masai.model.Cab;

public interface CabService {

	public Cab addCab(Cab b, Integer driverID);	
	
	List<Cab> getAllCabs();

    Cab getCabById(Integer id);

    Cab updateCab(Integer id, Cab cab);

    void deleteCab(Integer id);

    List<Cab> getAvailableCabs();
	
}
