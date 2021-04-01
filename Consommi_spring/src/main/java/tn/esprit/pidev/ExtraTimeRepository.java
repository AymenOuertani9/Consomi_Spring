package tn.esprit.pidev.repsitory;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.ExtraTime;
import tn.esprit.pidev.entities.UserEtat;

@Repository
public interface ExtraTimeRepository extends CrudRepository<ExtraTime, Integer> {

	@Modifying
	@Query("update ExtraTime d set d.nbrHour = :nbrHour where d.id = :id")
	@Transactional
	void updateNbHour( @Param(value = "id") int id, @Param(value = "nbrHour") int nbrHour);
	
	@Modifying
	@Query("update UserConsomi d set d.etat = :etat where d.id = :id")
	@Transactional
	void updateUser( @Param(value = "id") int id, @Param(value = "etat") UserEtat etat);
}
