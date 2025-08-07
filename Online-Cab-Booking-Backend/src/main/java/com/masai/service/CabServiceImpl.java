package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masai.exception.CabNotFoundException;
import com.masai.exception.SomethingWentWrong;
import com.masai.model.Cab;
import com.masai.model.Driver;
import com.masai.respository.CabRepository;
import com.masai.respository.DriverRepository;

@Service
public class CabServiceImpl implements CabService {

	private CabRepository cabRepo;
	private DriverRepository driverRepo;
	
	public CabServiceImpl(CabRepository cabRepo, DriverRepository driverRepo) {
		super();
		this.cabRepo = cabRepo;
		this.driverRepo = driverRepo;
	}


	@Override
	public Cab addCab(Cab b, Integer driverID) {
		
		Optional<Driver> driver = driverRepo.findById(driverID);
		
		if(driver.isPresent())
		{
			b.setDriver(driver.get());
			
		}else {
			throw new SomethingWentWrong("no driver with given id "+ driverID);
		}
		
		Cab cab = cabRepo.save(b);
		

		return cab;
	}
	
	@Override
    public List<Cab> getAllCabs() {
        return cabRepo.findAll();
    }

    @Override
    public Cab getCabById(Integer id) {
        return cabRepo.findById(id)
                .orElseThrow(() -> new CabNotFoundException("Cab not found with ID: " + id));
    }

    @Override
    public Cab updateCab(Integer id, Cab updatedCab) {
        Cab existing = getCabById(id);

        existing.setType(updatedCab.getType());
        existing.setPerKmRate(updatedCab.getPerKmRate());
        existing.setIsAvailable(updatedCab.getIsAvailable());

        return cabRepo.save(existing);
    }

    @Override
    public void deleteCab(Integer id) {
        Cab cab = getCabById(id);
        cabRepo.delete(cab);
    }

    @Override
    public List<Cab> getAvailableCabs() {
        return cabRepo.findByIsAvailableTrue();
    }
	

}
