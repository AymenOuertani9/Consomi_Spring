package tn.esprit.pidev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.services.IRatingService;


@RestController
public class RatingPubController {
		
@Autowired
IRatingService rat;
		
		@PostMapping("/Forum/Publication/AddRating/{idUser}/{idPub}/{valueRating}")
		public String addRatingToPub(@PathVariable("idUser") int idUser,@PathVariable("idPub")int idPub ,@PathVariable("valueRating")int ratingValue) 
		{
			return rat.addRatingPub(idUser, idPub, ratingValue);
		}
	
		
		
	@GetMapping("/Forum/Publications/rating/{idPub}/{idUser}")
	public float getRatingByPublicationAndUser(@PathVariable("idPub")int idPub,@PathVariable("idUser") int idUser) {
	   
		return rat.getValueRatingByPublicationAndUser(idPub, idUser);
		}
		
	


}
