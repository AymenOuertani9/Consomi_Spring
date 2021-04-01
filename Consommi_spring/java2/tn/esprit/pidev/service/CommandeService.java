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

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.EtatDelivry;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.ModePayement;
import tn.esprit.pidev.entities.PaginationResult;
import tn.esprit.pidev.entities.Product;
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
	public void affecterCartACommand(int cartId, int commandId,int tva ,int deliveryid) {
		
		Delivery delivery=delivrep.findById(deliveryid).get();
		Command cmd = comrep.findById(commandId).get();
		Cart c = cartrep.findById(cartId).get();
		cmd.setCart(c);
		cmd.setAmountCommand(c.getTotal()+tva+delivery.getFraislivraison());
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
	//afficher cmd ordonnées par datesend dec
	@Override
	public List<Command> selectAllorderbydate() {
		
		return comrep.selectAll();
	}
	public double getAmountCommand(int cartId,int comandId,int iduser) {
	/*	Cart cart = cartrep.findById(cartId).get();
		Delivery delivery=delivrep.findById(deliveryid).get();
		Command c = new Command();
			double totalligne=cart.getTotal();
			 double AmountCommand=c.getAmountCommand()+delivery.getFraislivraison();
			 AmountCommand=AmountCommand+totalligne;
			*/
		Cart cart = cartrep.findById(cartId).get();
		Command cmd = comrep.findById(comandId).get();
		List<User>users=new ArrayList<>();
		users.add(cart.getUser());
		double total=0;
		for(User u:users) {
	   total=comrep.gettotalcommand(iduser,cartId);
	    cmd.setAmountCommand(total);     
		}
		comrep.save(cmd);
		return total;
			
		
			
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
	 //afficher les cmd ordonnées par date creation  decroisant
	@Override
	
	public List<Command> findByOrderByOrderDatecreationDesc() {
		
		return comrep.findByOrderByOrderDatecreationDesc();
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
	@Override
	public long count(Etat etat) {
		
		return comrep.count(etat);
	}


	@Override
	public List<Command> findByEtatOrderByDatecreationDesc(Etat etat) {
		
		return comrep.findByEtatOrderByDatecreationDesc(etat);
	}


	@Override
	public List<Command> findByPayement(ModePayement payement) {
		
		return comrep.findByPayement(payement);
	}


	@Override
	public String updatestatus( Boolean validpayement,int idcmd) {
		
		Command cmd = comrep.findById(idcmd).get();
		if(validpayement==true) {
			cmd.setEtat(Etat.ORDERED);
			comrep.save(cmd);
			return "the order is validated";
		}
		else if(validpayement==false)
		{
			cmd.setEtat(Etat.COMPLETE);
			comrep.save(cmd);
			return "the order is complete ";
		}
		return "";
		
		}
	@Override
		public String updatestatusbydelivred( int iddelivery,int idcmd) {
			Delivery delivery =delivrep.findById(iddelivery).get();
			Command cmd = comrep.findById(idcmd).get();
		if(delivery.getEtat()==EtatDelivry.DELIVRED) {
			cmd.setEtat(Etat.DELIVERY);
			comrep.save(cmd);
			return "the order is delivered";
		}
		else if (delivery.getEtat()==EtatDelivry.encours){
			cmd.setEtat(Etat.PREPARING);
			comrep.save(cmd);
			return "the order is PREPARING";
		}
		else if (delivery.getEtat()==EtatDelivry.NDELIVRED) {
			cmd.setEtat(Etat.CANCELED);
			comrep.save(cmd);
			return "the order is canceled";
			
		}
		else {
			return "";
		}
		
	}
	
	@Override
	public Command findByDateCreation(Date datecreation) {
		
		return comrep.findByDateCreation(datecreation);
	}


	@Override
	public List<Command> findAllByDateCreation(Date datecreation) {
		
		return (List<Command>)comrep.getCommandByDateCreation(datecreation);
	}


	@Override
	public Command findCommandUser(int iduser, int idc) {
		
		Command cmd = comrep.findById(idc).get();
		List<User>users=new ArrayList<>();
		users.add(cmd.getUser());
		for(User u:users) {
		cmd= comrep.getOne(idc);
	}
	
return cmd;
	}
	
	
}
