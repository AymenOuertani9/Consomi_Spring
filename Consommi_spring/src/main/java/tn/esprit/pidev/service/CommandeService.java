package tn.esprit.pidev.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.ModePayement;
import tn.esprit.pidev.entities.PaginationResult;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.ICartRepository;
import tn.esprit.pidev.repository.ICommandRepository;
import tn.esprit.pidev.repository.IUserRepository;
@Service
public class CommandeService implements ICommandeService{
@Autowired
ICommandRepository comrep;
@Autowired
ICartRepository cartrep;
@Autowired
IUserRepository userep;
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
	public void desaffecterCartduCommand(int cartId, int commandId) {
		
		
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
	
}
