package tn.esprit.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Publication;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.services.IPublicationService;


@RestController
public class RestControlPublication {
	
	@Autowired
	IPublicationService Pub;

	
	//http://localhost:8085/ajouterPublication
		@PostMapping("/user/ajouterPublication")
		@ResponseBody()
		public Publication ajouterEmploye(@RequestBody() Publication publication)
		{
//	        Optional<tn.esprit.pidev.entities.User> User = userrep1.findByUserName((user.getUserName()));
//	        if (User != null) throw new RuntimeException("this Client already exists");

			Pub.ajouterPublication(publication);
			return publication;
		}
		
		//http://localhost:8085/ajouterPublication/{idpub}
		@DeleteMapping("/user/deletePublicationById/{idpub}") 
		@ResponseBody 
		public void deletePublicationById(@PathVariable("idpub")int idpub) {
			Pub.deletePublicationById(idpub);
			
		}
//		
//		//http://localhost:8085/updatePublicationById/{idpub}
//		@PutMapping("/user/updatePublicationById/{idpub}") 
//		@ResponseBody 
//		public void updatePublicationById(@PathVariable("idpub")int pubup) {
//				Pub.mettreAjourPublicationById(pubup);
//					
//				}
		@PutMapping(value = "user/updatePublicationById/{id}/{newtopic}") 
	 	@ResponseBody
		public void mettreAjourEmailByEmployeIdJPQL(@PathVariable("newtopic") String topic, @PathVariable("id") int idpub) {	
		Pub.mettreAjourPublicationById(topic, idpub);;
			
		}
				
				
	@GetMapping(value ="/user/getAllPublicationJPQL")
	@ResponseBody
	public List<String> getAllPublicationJPQL() {
					
	return Pub.getAllPublicationJPQL();
				}		
		
}
