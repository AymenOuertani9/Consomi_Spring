package tn.esprit.pidev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.pidev.entities.Rating;
import tn.esprit.pidev.entities.Publication;


public interface RatingRepository extends JpaRepository<Rating, Integer> {
	
	@Query("select e.publication from Rating e ")
	public List<Publication> evsave();
	
	@Query("select e from Rating e where e.publication=:publication")
	public Rating findev(@Param("publication") Publication publication);
	
	
	@Query("SELECT rat FROM Rating rat WHERE rat.publication.id=:idPub AND rat.user.id=:idUser ")
	public List<Rating> findRatingPubByPublicationAndUser(@Param("idPub")int idPub,@Param("idUser")int idUser);

	@Query("SELECT AVG(rat.nbretoile) FROM Rating rat")
	public int getAvgOfValueRating();



}
