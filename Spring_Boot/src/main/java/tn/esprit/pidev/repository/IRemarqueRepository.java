package tn.esprit.pidev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.pidev.entities.Remarque;

@Repository
public interface IRemarqueRepository extends JpaRepository<Remarque, Integer>{
	@Query("select r from Remarque r "
			+ "join r.comande c "
			+ "join c.cart ca "
			+ "join ca.user u "
			+ "where u.iduser=:userId")
	public List<Remarque> getremarqueByIduser(@Param("userId")int userId);
}
