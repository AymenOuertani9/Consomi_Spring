package tn.esprit.pidev.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.ModePayement;
@Repository
public interface ICommandRepository extends JpaRepository<Command, Integer>{
	/*@Query("select c from Commande c where c.numcommand=:num and c.Etat=:valide and c.DateSend=:datesend and c.DateCreation=:datecree and c.AmountCommand=:amount and c.payement=:enligne and c.validpayement=:v")
	public List<Command> getCommandesOfClient(@Param("num")int numcommand,@Param("valide") String Etat,@Param("datesend")  Date DateSend,@Param("datecree") Date DateCreation,
			@Param("amount") double AmountCommand,@Param("enligne") ModePayement payement,@Param("v") Boolean validpayement);*/
	@Query("select Max(numcommand) from Command ")
	public int getMaxNumcommand();
	
	@Query("select DISTINCT c from Command c "
			+ "join c.cart t "
		    + "where t.idcart=:cartid")
	public Command findCommandByCart(@Param("cartid")int cartid);
	
	@Query("select DISTINCT c from Command c "
		    + "join c.user u "
			+ "where u.iduser=:userid")
public List<Command >getAllCommandByUser(@Param("userid")int userId);

}
