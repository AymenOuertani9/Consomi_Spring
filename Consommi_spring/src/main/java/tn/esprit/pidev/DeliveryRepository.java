package tn.esprit.pidev.repsitory;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.DeliveryEtat;
import tn.esprit.pidev.entities.DeliveryRegion;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.UserConsomi;




public interface DeliveryRepository extends CrudRepository<Delivery, Integer> {
	
	@Modifying
	@Query("update Delivery d set d.etat = :etat where d.idDelivery = :id")
	@Transactional
	void updateEtat( @Param(value = "id") int id, @Param(value = "etat") DeliveryEtat etat);
	
	
	
	
	@Modifying
	@Query("update Delivery d set d.rate = :rate where d.idDelivery = :id")
	@Transactional
	void updateRate( @Param(value = "id") int id, @Param(value = "rate") int rate);
	
    @Query("Select "
			+ "DISTINCT delivery from Delivery delivery "
			+ "join delivery.user u "
			+ "where u.iduser=:id")
    public List<Delivery> getAllDeliveryByDeliveryMan(@Param("id") int id);
    
   
	
    @Query("Select t from UserConsomi t "
			+ "where t.availability=:av and "
			+ "t.workzone=:w and "
			+ "t.role=:r")
    public UserConsomi findDeliveryMan(@Param("w")DeliveryRegion workzone, @Param("av")Boolean availability, @Param("r")String role);
    
    @Query("Select t from Command t "
			+ "where t.etat=:etat")
    public Command findCommand(@Param("etat")Etat etat );
    
    @Query("Select  "
			+ "DISTINCT delivery from Delivery delivery "
			+ "join delivery.commande c "
			+ "where c.idcommand=:id")
    public Delivery findDelivery(@Param("id") int id);
    
    
	
	

	

	
	

}
