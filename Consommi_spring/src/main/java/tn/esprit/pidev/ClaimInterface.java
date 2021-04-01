package tn.esprit.pidev.serviceInterface;

import java.util.List;

import tn.esprit.pidev.entities.Claim;
import tn.esprit.pidev.entities.ClaimEtat;


public interface ClaimInterface {
	
	public void saveClaim(Claim claim);
	public void updateClaimEtat(int id , ClaimEtat etat);
	public void deleteClaim(int id);
	public List<Claim> getAllClaim();

}
