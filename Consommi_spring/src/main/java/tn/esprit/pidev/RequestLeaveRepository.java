package tn.esprit.pidev.repsitory;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.RequestLeave;
import tn.esprit.pidev.entities.RequestLeaveEtat;

@Repository
public interface RequestLeaveRepository extends CrudRepository<RequestLeave, Integer> {
	
	@Modifying
	@Query("update RequestLeave d set d.etat = :etat where d.idRequestLeave = :id")
	@Transactional
	void updateEtat( @Param(value = "id") int id, @Param(value = "etat") RequestLeaveEtat etat);

}
