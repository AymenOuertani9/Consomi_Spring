package tn.esprit.pidev.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.xml.bind.ParseConversionEvent;

import org.hibernate.Session;
import org.slf4j.helpers.BasicMDCAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.ModePayement;
import tn.esprit.pidev.entities.PaginationResult;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.ICartRepository;
import tn.esprit.pidev.repository.ICommandRepository;
import tn.esprit.pidev.repository.IDeliveryRepository;
import tn.esprit.pidev.repository.IUserRepository;
@Service
public class CommandeService implements ICommandeService{
@Autowired
ICommandRepository comrep;
@Autowired
ICartRepository cartrep;
@Autowired
IUserRepository userep;
@Autowired
IDeliveryRepository delivrep;
private Command commande;

	@Override
	public List<Command> getCommandes() {
		
		return comrep.findAll();
	}
	/*@Override
	public List<Command> getCommandesOfClient(int numcommand, String Etat, Date DateSend, Date DateCreation,
			double AmountCommand, ModePayement payement, Boolean validpayement) {
		
		return comrep.getCommandesOfClient(numcommand, Etat, DateSend, DateCreation, AmountCommand, payement, validpayement);
	}
*/
	@Override
	public void saveCommande(Cart cart) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public PaginationResult<Command> listCommande(int page, int maxResult, int maxNavigationPage) {
		// @page = 1, 2, ...
	        String sql = "Select new " + Command.class.getName()//
	                + "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
	                + " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
	                + Command.class.getName() + " ord "//
	                + " order by ord.orderNum desc";
	        //Session session = this.sessionFactory.getCurrentSession();
	 
	      //  Query query = session.createQuery(sql);
	 
	        return new PaginationResult<Command>(page, maxResult, maxNavigationPage);
	    }
	
	@Override
	public Command getCommande(int idcommand) {
		
		return comrep.findById(idcommand).get();
	}
	@Override
	public List<Command> listCommand(int idcommand) {
	
		return comrep.findAll();
	}
	@Override
	public int getMaxNumcommand() {
		
		return comrep.getMaxNumcommand();
	}
	@Override
	public Command findCommandByCart(int cartid) {
		
		return comrep.findCommandByCart(cartid);
	}
	//afficher historique de cmd de chaque user
	@Override
	public List<Command > findCommandByUser(int userid) {
		
		return comrep.getAllCommandByUser(userid);
	}
	@Override
	public void affecterCartACommand(int cartId, int commandId) {
		Command cmd = comrep.findById(commandId).get();
		Cart c = cartrep.findById(cartId).get();
		cmd.setCart(c);
		comrep.save(cmd);
		
	}
	@Override
	public void affecterCommandAUser(int userId, int commandId) {
		Command cmd = comrep.findById(commandId).get();
		User u =userep.findById(userId).get();
		cmd.setUser(u);
		comrep.save(cmd);
		
	}
	
	@Override
	public Command AjouterCommand(Command c) {
		// TODO Auto-generated method stub
		return comrep.save(c);
	}
	@Override
	public void deleteCommandById(int comandId) {
		Command cmd = comrep.findById(comandId).get();
		comrep.delete(cmd);
		
	}
	@Override
	public int addOrUpdateCommand(Command c) {
		// TODO Auto-generated method stub
		 comrep.save(c);
		 return c.getIdcommand();
	}
	
	@Override
	public List<Command> selectAllorderbydate() {
		
		return comrep.selectAll();
	}
	public double getAmountCommand(int cartId,int tva,int deliveryid) {
		Cart cart = cartrep.findById(cartId).get();
		Delivery delivery=delivrep.findById(deliveryid).get();
		Command c = new Command();
			double totalligne=cart.getTotal()+tva;
			 double AmountCommand=c.getAmountCommand()+delivery.getFraislivraison();
			 AmountCommand=AmountCommand+totalligne;
			
			
		
		return AmountCommand;	
	}
	public void creercommande() {
		
		commande=new Command();
		//commande.setUser(user);
		commande.setDateCreation(new Date());
		commande.setDateSend(new Date());
		commande.setNumcommand(generatenumcommand());
		comrep.save(commande);
	}
	public int generatenumcommand() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().hashCode();
	}
	@Override
	public void modifiercommande(User user) {
		if(user==null) {
			return;
		}
		if(commande!=null) {
			commande.setUser(user);
			comrep.save(commande);
		}
	}
	 @Transactional
	  public void cancel( int id) {
	   Command order = comrep.findById(id).get();
	   /* if (!order.getUser().equals(currentUser))
	      throw new RuntimeException("not current user");*/

	    order.setEtat(Etat.CANCELED);
	    comrep.save(order);
	  }
	@Override
	
	public List<Command> findByOrderByOrderDatecreationDesc() {
		
		return comrep.findByOrderByOrderDatecreationDesc();
	}
	@Override
	public Command findByOrderStatusOrderByOrderDateDesc(String etat) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer countBetween(Date d1, Date d2) {
		
		return comrep.countBetween(d1, d2);
	}
	@Transactional
	public void saveCommande( double AmountCommand,int cartId,int userid,ModePayement payement,Boolean validpayement) {
		Etat etat =null;
		int tva=18;
		Command cmd = new Command();
		Cart cart = cartrep.findById(cartId).get();
		User u =userep.findById(userid).get();
		cmd.setAmountCommand(AmountCommand);
		cmd.setUser(u);
		cmd.setCart(cart);
		cmd.setPayement(payement);
		cmd.setValidpayement(validpayement);
		cmd.setNumcommand(generatenumcommand());
		cmd.setEtat(etat.COMPLETE); 
		cmd.setDateCreation(new Date());
		cmd.setDateSend(new Date());
		cmd.setTva(tva);
		comrep.save(cmd);
		
	}
}
