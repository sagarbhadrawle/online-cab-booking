package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.model.Cab;
import com.masai.respository.CabRepository;

@Service
public class CabServiceImpl implements CabService {

	private CabRepository cabRepo;

	public CabServiceImpl(CabRepository cabRepo) {
		super();
		this.cabRepo = cabRepo;
	}

	@Override
	public Cab addCab(Cab b) {
		Cab cab = cabRepo.save(b);

		return cab;
	}

}
