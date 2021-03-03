package tn.esprit.pidev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.pidev.entities.Publication;
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
	
	@Query("SELECT topic FROM Publication")
    public List<String> publication();
	
    @Modifying
    @Transactional
    @Query("UPDATE Publication e SET e.topic=:topic1 where e.idpub=:pubId")
    public void mettreAjourtopicByPublication(@Param("topic1")String topic, @Param("pubId")int pubId);
    

}
