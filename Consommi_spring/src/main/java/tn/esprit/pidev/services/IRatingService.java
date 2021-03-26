package tn.esprit.pidev.services;

import tn.esprit.pidev.entities.Rating;

public interface IRatingService {
	public String addRatingPub(int idUser,int idPub,int ratingValue);
	public String updateRatingPub(Rating ratPub);
	public float getAvgRat();
	public float getValueRatingByPublicationAndUser(int idPub,int idUser);


}
