package tn.esprit.pidev.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.ModePayement;
import tn.esprit.pidev.entities.Product;
@Repository
public interface ICommandRepository extends JpaRepository<Command, Integer>{
	
	@Query("select Max(numcommand) from Command ")
	public int getMaxNumcommand();
	
	@Query("select DISTINCT c from Command c "
			+ "join c.cart t "
		    + "where t.idcart=:cartid")
	public Command findCommandByCart(@Param("cartid")int cartid);
	
	@Query("select DISTINCT c from Command c "
			+ "join c.cart ca "
			+ "join ca.user u "
			+ "where u.iduser=:userid")
public List<Command >getAllCommandByUser(@Param("userid")int userId);
	@Query("select c FROM Command c ORDER BY c.dateCreation DESC")
	public List<Command> selectAll();
	@Query("select count(p) from Command p where p.dateSend between :d1 and :d2")
	public Integer countBetween(@Param("d1")Date d1, @Param("d2")Date d2);
	@Query("select c FROM Command c ORDER BY c.dateCreation DESC")
	public List<Command> findByOrderByOrderDatecreationDesc() ;
	@Query("select count(c) from Command c where c.etat=:x ")
	public long count(@Param("x") Etat etat);
	@Query("select c FROM Command c where c.etat=:x ORDER BY c.dateCreation DESC")
	public List<Command> findByEtatOrderByDatecreationDesc(@Param("x") Etat etat) ;
	public List<Command >findByPayement(ModePayement payement);
	public Command findByDateCreation(Date datecreation);
	@Query("SELECT (c.subtotal) FROM Cart c "
			
			+ "where  c.idcart=:cartid")
	
	public double gettotalcommand( @Param("cartid")int cartid);
	//@Query("select c FROM Command c where (c.dateCreation=:dc) order by c.dateSend desc")
	public List<Command> getCommandByDateCreation(Date datecreation); 
	 @Query("select c from Command c where c.dateCreation <= :creationDateTime")
	  public  List<Command> findAllWithCreationDateTimeBefore( @Param("creationDateTime") Date creationDateTime);
	 @Modifying
	    @Transactional
	    @Query("DELETE FROM Command c WHERE c.dateSend < :date")
	   public  int removeOlderThan(@Param("date") java.sql.Date date);
	
}
	