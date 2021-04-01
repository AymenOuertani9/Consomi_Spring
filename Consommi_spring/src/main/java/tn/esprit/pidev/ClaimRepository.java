package tn.esprit.pidev.repsitory;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Claim;
import tn.esprit.pidev.entities.ClaimEtat;
import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.DeliveryEtat;
import tn.esprit.pidev.entities.LigneCommande;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Integer> {
	
	
	
	@Modifying
	@Query("update Claim d set d.etat = :etat where d.id = :id")
	@Transactional
	void updateClaimEtat( @Param(value = "id") int id, @Param(value = "etat") ClaimEtat etat);
	
	@Modifying
	@Query("update Claim d set d.etat = :etat where d.id = :id" )
	@Transactional
	void updateEtatToRefuse(  @Param(value = "id") int id ,@Param(value = "etat") ClaimEtat etat);
	
	
	@Query("Select "
			+ "DISTINCT cart from Cart cart "
			+ "join cart.user u "
			+ "where u.iduser=:id and "
			+ "cart.etat=:et")
    public List<Cart> findCart(@Param("id") int id, @Param("et") Boolean et);
	
	@Query("Select "
			+ "DISTINCT l from LigneCommande l "
			+ "join l.product prod "
			+ "join l.cart c "
			+ "join c.user u "
			+ "where u.id=:id and "
			+ "c.etat=:etat and "
			+ "prod.id=:prod")
    public LigneCommande findLigneCommande(@Param("prod")int prod, @Param("id")int id, @Param("etat")Boolean etat);
	
	@Query("Select "
			+ "DISTINCT d from Delivery d "
			+ "join d.commande c "
			+ "join c.cart cart "
			+ "where cart.id=:cart and "
			+ "d.etat=:e")
    public Delivery findDelivery(@Param("e")DeliveryEtat e, @Param("cart")int cart);

}
