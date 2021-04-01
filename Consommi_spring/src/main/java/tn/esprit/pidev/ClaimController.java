package tn.esprit.pidev.controller;


import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.pidev.entities.Claim;
import tn.esprit.pidev.entities.ClaimEtat;
import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.DeliveryEtat;
import tn.esprit.pidev.entities.LigneCommande;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repsitory.ClaimRepository;
import tn.esprit.pidev.repsitory.UserRepository;
import tn.esprit.pidev.service.ClaimService;
import tn.esprit.pidev.service.DeliveryService;


@RestController
@CrossOrigin("*")
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClaimRepository claimRepository;
	
	@Autowired
	private DeliveryService deliveryService;
	
	@Value("${app.twillio.fromPhoneNo}")
	private String from;
	
	/****************************************Create*************************************************************************************/
	
	@PostMapping(value = "saveClaim/{prod}")
	
	public String addNewClaim(@RequestBody Claim claim , @PathVariable int prod , boolean etat   , DeliveryEtat e ) {
		
		UserConsomi user = userRepository.findById(1).get();
		
		etat = true;
		int id = user.getIduser();
		e = DeliveryEtat.delivered;

		
		LigneCommande ligneCommande = claimRepository.findLigneCommande(prod, id, etat);
		int cart = claimRepository.findLigneCommande(prod, id, etat).getCart().getIdcart();
		
		Delivery delivery = claimRepository.findDelivery(e, cart);
		if(ligneCommande != null)  
		{
			if(delivery != null)
			{
				Random rnd = new Random();
				int a = rnd.nextInt() ;
				
				claim.setReference("claim_"+a);
				claim.setUser(user);
				claim.setEtat(ClaimEtat.in_progress);
				claim.setDateClaim(new Date());	
				//Product product = productRepository.findById(prod).get();
				claim.setProduct(ligneCommande.getProduct());
					
				System.out.println("At Controller Add");
				claimService.saveClaim(claim);
				
				if( (claim.getDateClaim().getYear()>delivery.getCommande().getDateSend().getYear()) & (claim.getDateClaim().getMonth()>delivery.getCommande().getDateSend().getDay()) )
				{
					ClaimEtat et = ClaimEtat.refuse;
					int i = claim.getIdclaim();
					claimRepository.updateEtatToRefuse( i ,et);

					return "your warranty period has expired ";
					
				}
				
					return "Added Successfully";

			}
			else
			{
				return"you have not yet received your product ";
			}
			
		}
		else
			{
				return"you haven't yet by this product";
			}
		
	}
	
	/*********************************************UpdateEtat********************************************************************************/
	
	@PutMapping(value = "updateClaimEtat/{id}")
	
	public String updateEtat(@PathVariable int id ,  @RequestBody ClaimEtat etat ) {
		
		Claim claim = claimRepository.findById(id).get();
		
		if(etat==ClaimEtat.refund)
		{
			claim.setAmount(claim.getProduct().getPrice());
			
		}
		
		if(claim.getEtat()==etat)
		{
			return"etat is already : "+etat;
		}
		
		claimRepository.updateClaimEtat(id, etat);

		
			/*UserConsomi user = userRepository.findById(1).get();
			String a =user.getTel();
			
			String body = "the status of your complaint has been changed to"+etat;
			deliveryService.sendSms("+216"+a, from, body);*/
		
		System.out.println("etat was changed");
		return"etat was changed to : "+etat;

	}
	
	/*********************************************delete********************************************************************************/
	
	@DeleteMapping(value = "deleteClaim/{id}")
	public String deleteClaim(@PathVariable int id) {
		System.out.println("Claim was deleted");
		claimService.deleteClaim(id);
		
		return "Claim Deleted";
	}
	
	/*********************************************find All ********************************************************************************/

	@RequestMapping("/findAllClaim")
	public List<Claim> findAllClaim(){
		return claimService.getAllClaim();
	}
	
	/********************************************************test*********************************************************************/
	
	@GetMapping(value = "test/{prod}/{id}")
	public LigneCommande test( @PathVariable int prod,   Boolean etat , @PathVariable int id) {
		etat = true;
		return claimRepository.findLigneCommande(prod, id, etat);
	}

}
