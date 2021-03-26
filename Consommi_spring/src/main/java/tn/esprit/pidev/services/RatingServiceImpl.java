package tn.esprit.pidev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Publication;
import tn.esprit.pidev.entities.Rating;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repositories.PublicationRepository;
import tn.esprit.pidev.repositories.RatingRepository;
import tn.esprit.pidev.repositories.UserRepository;
@Service
public class RatingServiceImpl implements IRatingService{
	
	@Autowired
	RatingRepository ratPubRep;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PublicationRepository pubRepo;

	
	@Override
	public String addRatingPub(int idUser,int idPub ,int ratingValue) {
		// TODO Auto-generated method stub
		Rating rat = new Rating();
		UserConsomi user = userRepo.findById(idUser).orElse(null);
		Publication pub =pubRepo.findById(idPub).orElse(null);
		rat.setPublication(pub);
		rat.setUser(user);
		List<Rating> ratPub= ratPubRep.findRatingPubByPublicationAndUser(idPub, idUser);
		if(ratPub.size()!=0) {
			rat.setIdrating(ratPub.get(0).getIdrating());
			rat.setNbretoile(ratingValue);
			ratPub.get(0).setNbretoile(ratingValue);			
			updateRatingPub(ratPub.get(0)); 
			return "Rating is updating successfully";
		}

		rat.setNbretoile(ratingValue);
		ratPubRep.save(rat);
		
		return "Rating is done successfully";
		
	}
	
	@Override
	public String updateRatingPub(Rating ratPub) {
		// TODO Auto-generated method stub
		ratPubRep.save(ratPub);
		return "successful update";
	}

	@Override
	public float getAvgRat() {
		// TODO Auto-generated method stub
		return ratPubRep.getAvgOfValueRating();
	}

	@Override
	public float getValueRatingByPublicationAndUser(int idPub, int idUser) {
		List<Rating> ratPub= ratPubRep.findRatingPubByPublicationAndUser(idPub, idUser);
		if(ratPub.size()!=0) return ratPub.get(0).getNbretoile();
		
		return getAvgRat();
	}
	


}
