package tn.esprit.pidev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {
	
	@Query("SELECT count(*) FROM Contrat")
    public int countemp();
	
	
}
