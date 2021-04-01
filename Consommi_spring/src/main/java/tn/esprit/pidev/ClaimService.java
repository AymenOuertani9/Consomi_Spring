package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Claim;
import tn.esprit.pidev.entities.ClaimEtat;
import tn.esprit.pidev.repsitory.ClaimRepository;
import tn.esprit.pidev.serviceInterface.ClaimInterface;
@Service
public class ClaimService implements ClaimInterface{
	
	@Autowired
	private ClaimRepository claimRepository;

	@Override
	public void saveClaim(Claim claim) {
		claimRepository.save(claim);
		
	}

	@Override
	public void updateClaimEtat(int id , ClaimEtat etat) {
		// TODO Auto-generated method stub
		 claimRepository.updateClaimEtat(id , etat);
	}

	@Override
	public void deleteClaim(int id) {
		claimRepository.deleteById(id);
		
	}

	@Override
	public List<Claim> getAllClaim() {
		// TODO Auto-generated method stub
		return (List<Claim>) claimRepository.findAll();
	}

}
