package tn.esprit.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.supplying;
import tn.esprit.pidev.repository.ISupplyingRepository;


@Service
public class SupplyingService implements ISupplyingService {
	
	@Autowired
	ISupplyingRepository supplyingrepository;
	@Override
	public String AddSupplying(supplying supplyin) {
		// TODO Auto-generated method stub
		supplyingrepository.save(supplyin);
		return "Supplying Added";
	}
	
	
	

}
