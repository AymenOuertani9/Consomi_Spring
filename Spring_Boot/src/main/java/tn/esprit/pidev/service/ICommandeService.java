package tn.esprit.pidev.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

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

	public List<Command> listCommand();
	public int getMaxNumcommand() ;
	public Command findCommandByCart(int cartid);
	public List<Command >findCommandByUser(int userid);
	public String affecterCartACommand(int cartId );
	//public void affecterCommandAUser(int userId, int commandId);
	public void cancel(int id);
	//public ResponseEntity<Object> AjouterCommand(Command c);
	public String  deleteCommandById(int idc);
	//public ResponseEntity<String> addOrUpdateCommand(Command c);
	public List<Command> selectAllorderbydate();
	public String getAmountCommand(int cartId);
	public int generatenumcommand();
	//public void creercommande();
	public ResponseEntity<String> modifiercommande(Command commande);
	public List<Command> findByOrderByOrderDatecreationDesc();
	//public void saveCommande( double AmountCommand,int cartId,int userid ,ModePayement payement,Boolean validpayement);
	public List<Command> findByEtatOrderByDatecreationDesc(Etat etat);
	public Integer countBetween(Date d1, Date d2);
	public long count(Etat etat);
	public List<Command >findByPayement(ModePayement payement);
	public String updatestatus( Boolean validpayement,int idcmd);
	public String updatestatusbydelivred( int iddelivery,int idcmd);

	public List<Command> findAllByDateCreation(Date datecreation); 

	public Command findByDateCreation(Date datecreation);
	public Command findCommandUser(int iduser  ,int idc);
	public String payinthreemonths(int idc ,int cpte1, int cpte2,int deliveryid);
	public String payin6months(int idc ,int cpte1, int cpte2,int deliveryid) ;
	public String payin9months(int idc ,int cpte1, int cpte2,int deliveryid);
	public String payin12months(int idc ,int cpte1, int cpte2,int deliveryid);
	public String addprogrammefidelite(int idfidel);
	public String paymentbyfidelite(int userid ,  int idcpt,int deliveryid);

	public String reductionsurcommande(int idcart);

	public void performCommandCleanup();
}
