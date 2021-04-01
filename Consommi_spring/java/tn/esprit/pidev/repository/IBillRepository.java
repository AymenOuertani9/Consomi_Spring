package tn.esprit.pidev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Bill;


@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer>{
	@Query("select b from Bill b "
			+ "join b.command c "
			+ "join c.user u "
			+ "where u.iduser=:userId")
	public List<Bill> getbillByIduser(@Param("userId")int userId);
	@Query("select p from Bill p where p.numBill=:num")
	public Bill find(@Param("num")int numero);
	@Query("select coalesce(sum(p.totalfinal),0) from Bill p where p.user=null ")
	public Double prixAchatsProduits();

	
}
