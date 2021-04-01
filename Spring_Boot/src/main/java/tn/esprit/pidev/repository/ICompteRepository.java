package tn.esprit.pidev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Compte;

@Repository
public interface ICompteRepository extends JpaRepository<Compte, Integer>{
	@Query("select c from Compte c "
			+ "join c.user u "
			+ "where u.iduser=:userId")
	public List<Compte> getCompteByIduser(@Param("userId")int iduser);
}
