package tn.esprit.pidev.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pidev.entities.Advertisement;
import tn.esprit.pidev.services.IAdvertisementService;
@RestController
public class AdvertisementController {
	@Autowired
	IAdvertisementService iAdvertisementService;
	
	//creating post mapping that post the advertisement detail in the database  
			@PostMapping("/advertisement/add-advertisement")  
			private int addAdvertisement(@RequestBody Advertisement adv)   
			{  
				iAdvertisementService.addAdvertisement(adv);  
				return adv.getIdAd();  
			}
	//creating a delete mapping that deletes a specified advertisement 
			@DeleteMapping("/advertisement/delete-advertisement/{advId}")  
			private void deleteAdvertisement(@PathVariable("advId") int advId)   
			{  
				iAdvertisementService.deleteAdvertisement(advId); 
			}
    //creating put mapping that updates the advertisement detail   
			@PutMapping("/advertisement/update-advertisement/{idAd}")  
			private Advertisement updateAdvertisement(@RequestBody Advertisement adv, @PathVariable("idAd")int idAd)   
			{  
				iAdvertisementService.updateAdvertisement(adv,idAd); 
				return adv;
			}
	//creating a get mapping that retrieves all the advertisement detail from the database   
			@GetMapping("/advertisement/get-all-advs")  
			private List<Advertisement> getAllAdvs()   
			{  
				return iAdvertisementService.getAllAdvertisements(); 
			}
	//creating a get mapping that retrieves the detail of a specific advertisement 
			@GetMapping("/advertisement/detail-advertisement/{idAd}")  
			private Advertisement getAdvertisement(@PathVariable("idAd") int idAd)   
			{  
				return iAdvertisementService.getAdvertisementById(idAd);
			} 
			//////////////
	//creating get mapping that getAdvertisementByName   
	        @GetMapping("/advertisement/retrieve-Advertisement-ByName/{name}")
			public Advertisement getAdvertisementByName(@PathVariable String name) {
	        	Advertisement adv = iAdvertisementService.findAdvertisementByName(name);
				return adv;
				}
    //creating put mapping that updates the event detail   
			@PutMapping("/advertisement/affecter-Ad-Typ/{typeAd}/{idadve}")  
			 private String affecterTypeAdEvent(@PathVariable("typeAd")String typeAd,@PathVariable("idadve")int idadv)   
			  {  
				return iAdvertisementService.affecterAdCategoryAdvertisement(typeAd, idadv);
			  }
	
}
