package tn.esprit.pidev.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.ModePayement;
import tn.esprit.pidev.entities.PaginationResult;
import tn.esprit.pidev.entities.User;

public interface ICommandeService {
	public List<Command> getCommandes();
	  
	

	public PaginationResult<Command> listCommande(int page, int maxResult, int maxNavigationPage);

	public Command getCommande(int idcommand);

	public List<Command> listCommand(int idcommand);
	public int getMaxNumcommand() ;
	public Command findCommandByCart(int cartid);
	public List<Command >findCommandByUser(int userid);
	public void affecterCartACommand(int cartId, int commandId,int tva,int deliveryid );
	public void affecterCommandAUser(int userId, int commandId);
	public void cancel(int id);
	public Command AjouterCommand(Command c);
	public void deleteCommandById(int comandId);
	public int addOrUpdateCommand(Command c);
	public List<Command> selectAllorderbydate();
	public double getAmountCommand(int cartId,int comandId,int iduser);
	public int generatenumcommand();
	public void creercommande();
	public void modifiercommande(User user);
	public List<Command> findByOrderByOrderDatecreationDesc();
	public void saveCommande( double AmountCommand,int cartId,int userid ,ModePayement payement,Boolean validpayement);
	public List<Command> findByEtatOrderByDatecreationDesc(Etat etat);
	public Integer countBetween(Date d1, Date d2);
	public long count(Etat etat);
	public List<Command >findByPayement(ModePayement payement);
	public String updatestatus( Boolean validpayement,int idcmd);
	public String updatestatusbydelivred( int iddelivery,int idcmd);

	public List<Command> findAllByDateCreation(Date datecreation); 

	public Command findByDateCreation(Date datecreation);
	public Command findCommandUser(int iduser  ,int idc);
}
