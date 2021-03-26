package tn.esprit.pidev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.pidev.entities.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
	@Modifying
    @Transactional
    @Query("UPDATE Commentaire e SET e.description=:description1 where e.idcomment=:commentId")
    public void mettreAjourdescriptionByCommentaire(@Param("description1")String description, @Param("commentId")int commentId);
    
	@Query("SELECT description FROM Commentaire")
    public List<String> Commentaire();
	
	 @Query("select c from Commentaire c  order by nblike desc")
	    List<Commentaire> CommentTop();
	 
	

}
