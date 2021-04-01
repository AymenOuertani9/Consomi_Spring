package tn.esprit.pidev.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.ModePayement;
import tn.esprit.pidev.entities.PaginationResult;
import tn.esprit.pidev.entities.User;

public interface ICommandeService {
	public List<Command> getCommandes();
	//public List<Command> getCommandesOfClient(int numcommand ,String Etat, Date DateSend,Date DateCreation, double AmountCommand,ModePayement payement,Boolean validpayement );   
	public void saveCommande(Cart cart);

	public PaginationResult<Command> listCommande(int page, int maxResult, int maxNavigationPage);

	public Command getCommande(int idcommand);

	public List<Command> listCommand(int idcommand);
	public int getMaxNumcommand() ;
	public Command findCommandByCart(int cartid);
	public List<Command >findCommandByUser(int userid);
	public void affecterCartACommand(int cartId, int commandId);
	public void affecterCommandAUser(int userId, int commandId);
	public void cancel(int id);
	public Command AjouterCommand(Command c);
	public void deleteCommandById(int comandId);
	public int addOrUpdateCommand(Command c);
	public List<Command> selectAllorderbydate();
	public double getAmountCommand(int cartId,int tva,int deliveryid);
	public int generatenumcommand();
	public void creercommande();
	public void modifiercommande(User user);
	public List<Command> findByOrderByOrderDatecreationDesc();
	public void saveCommande( double AmountCommand,int cartId,int userid ,ModePayement payement,Boolean validpayement);
	public Command findByOrderStatusOrderByOrderDateDesc(String etat);
	public Integer countBetween(Date d1, Date d2);
}
