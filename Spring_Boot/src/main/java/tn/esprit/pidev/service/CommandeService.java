package tn.esprit.pidev.service;

import java.net.URI;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.transaction.Transactional;
import javax.xml.bind.ParseConversionEvent;

import org.h2.api.Interval;
import org.hibernate.Session;
import org.slf4j.helpers.BasicMDCAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Compte;
import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.EtatCart;
import tn.esprit.pidev.entities.EtatDelivry;
import tn.esprit.pidev.entities.Etatfidelite;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.ModePayement;
import tn.esprit.pidev.entities.Operation;
import tn.esprit.pidev.entities.PaginationResult;
import tn.esprit.pidev.entities.Pays;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.ProgrammeFidelité;
import tn.esprit.pidev.entities.Retrait;
import tn.esprit.pidev.entities.Roletype;
import tn.esprit.pidev.entities.Typefidelite;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.entities.Versement;
import tn.esprit.pidev.repository.IBillRepository;
import tn.esprit.pidev.repository.ICartRepository;
import tn.esprit.pidev.repository.ICommandRepository;
import tn.esprit.pidev.repository.ICompteRepository;
import tn.esprit.pidev.repository.IDeliveryRepository;
import tn.esprit.pidev.repository.IProgramfideliteRepository;
import tn.esprit.pidev.repository.IUserRepository;
import tn.esprit.pidev.repository.OperationRepository;
@Service
@EnableScheduling
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
	@Autowired
	OperationRepository oprep;
	@Autowired
	ICompteRepository compterep;
	@Autowired
	IBillRepository bilrep;
	@Autowired
	IProgramfideliteRepository pfrep;
	
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

	//get all orders
	@Override
	public List<Command> listCommand() {

		return comrep.findAll();
	}
	//get order by id 
	@Override
	public Command getCommande(int idcommand) {

		return comrep.findById(idcommand).get();
	}

	//get num max of order
	@Override
	public int getMaxNumcommand() {

		return comrep.getMaxNumcommand();
	}
	//get order by cart
	@Override
	public Command findCommandByCart(int cartid) {

		return comrep.findCommandByCart(cartid);
	}
	//afficher historique de cmd de chaque user
	@Override
	public List<Command > findCommandByUser(int userid) {

		return comrep.getAllCommandByUser(userid);
	}

	public int generatenumcommand() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().hashCode();
	}
	//passer & enregistrer commande 
	@Override
	public String affecterCartACommand(int cartId ) {


		Command cmd = new Command();
		Cart c = cartrep.findById(cartId).get();
		double tot =c.getSubtotal();

		//cmd.setUser(c.getUser());
		cmd.setCart(c);
		cmd.setEtat(Etat.PREPARING);

		cmd.setPrice(c.getSubtotal());
		cmd.setDateCreation(new Date());
		cmd.setValidpayement(false);
		cmd.setNumcommand(this.generatenumcommand());
		cmd.setCurrency("TND");
		cmd.setIntent("Sale");
		cmd.setDescription("your order is in :"+cmd.getEtat());
		if(cmd.getCart().getUser().getPays()==Pays.TUNIS) {
			cmd.setTva(19);
		}else {
			cmd.setTva(0);
		}
		comrep.save(cmd);
		c.setEtatcart(EtatCart.noabandonedbasket);
		cartrep.save(c);
		return "you have passed an order with total "+tot;

	}

	
	@Override
	public String deleteCommandById(int idc) {
		//Command cmd = comrep.findById(comandId).get();
		comrep.deleteById(idc);
		return "the order is deleted with succefuly";

	}
	
	////////////////////////////afficher cmd ordonnées par datesend dec///////////////////////////////////////

	@Override
	public List<Command> selectAllorderbydate() {

		return comrep.selectAll();
	}
	public String getAmountCommand(int cartId) {
Command c = new Command();
		Cart cart = cartrep.findById(cartId).get();
	//	Command cmd = comrep.findById(comandId).get();
		
		List<Cart>cartss=new ArrayList<>();
		cartss.add(c.getCart());
		double total=0;
		for(Cart ca:cartss) {
		double tot1 =cart.getCommand().getReduction()/100;
		
			total=comrep.gettotalcommand(cartId);
			double totf=(total*tot1)+total;
			cart.getCommand().setPrice(totf);     
		
		comrep.save(cart.getCommand());
		
		return "your total is:"+" "+totf;
		}
			
		return "";

	}
	
	@Override
	public ResponseEntity<String> modifiercommande(Command commande) {


		//commande.setUser(user);
		Command savedc=comrep.save(commande);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedc.getIdcommand()).toUri();



		return ResponseEntity.ok("Order is successfully modified") ;
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

		Cart cmd = cartrep.findById(idc).get();
		List<User>users=new ArrayList<>();
		users.add(cmd.getUser());
		for(User u:users) {
			cmd= cartrep.getOne(idc);
		}



		return cmd.getCommand();
	}
	public boolean verser(int idcpt, double montant) {
		Compte cp = compterep.findById(idcpt).get();
		Operation o = new Versement();

		o.setDateOperation( new Date() );
		o.setMontant( montant );
		o.setCompte( cp );

		oprep.save( o );

		return true;


	}


	public boolean retirer(int idcpt, double montant) {
		Compte cp = compterep.findById(idcpt ).get();

		Operation o = new Retrait();

		o.setDateOperation( new Date() );
		o.setMontant( montant );
		o.setCompte( cp );


		oprep.save( o );

		return true;
	}
	//le 1er jour de mois et nimporte quel dayofweek
	//@Scheduled(cron="0 0 0 1 * ?", zone="Africa/Tunis")
	@Override	
	public String payinthreemonths(int idcmd ,int cpte1, int cpte2,int deliveryid) {
		
		Command cmd= comrep.findById(idcmd).get();
		
		Delivery d = delivrep.findById(deliveryid).get();
		//Bill b = bilrep.findById(idbill).get();
		Compte cp1 = compterep.findById(cpte1 ).get();
		Compte cp2 = compterep.findById(cpte2 ).get();
		if((cmd.getPrice()>=500)&&(cmd.getPaymentterm()==3) ){

			double montant=((cmd.getPrice()*0.1)+(cmd.getPrice()));

			if ( cp1.getSolde() < montant/3 )
				return ( "Solde insuffisant !" );

			retirer( cpte1, montant/3 );
			verser( cpte2, montant/3 );
			cmd.setPayement(ModePayement.BYFACILITY);
			cmd.setEtat(Etat.ORDERED);
			cmd.setMethod("virement");
			cmd.setDateSend(new Date());
			cmd.setValidpayement(true);
		
			cp1.setSolde( cp1.getSolde() - (montant/3) );
			cp2.setSolde( cp2.getSolde() + (montant/3) );
			compterep.save(cp1);
			compterep.save(cp2);
			if(cmd.getDateCreation().getTime()-new Date().getTime() ==2160) {
				cmd.setDelivery(d);
			}
			comrep.save(cmd);
			return "the invoice total will be increased to 10% and we will take "+" "+ montant/3+" "+"from your account each month";
		}
		else {
			return "you can't pay by facility";
		}	
	}
	//payment in 6 months 
	//@Scheduled(cron="0 0 0 1 * ?", zone="Africa/Tunis")
	@Override	
	public String payin6months(int idcmd ,int cpte1, int cpte2,int deliveryid) {
		Command cmd= comrep.findById(idcmd).get();
		//Bill b = bilrep.findById(idbill).get();
		Delivery d = delivrep.findById(deliveryid).get();
		Compte cp1 = compterep.findById(cpte1 ).get();
		Compte cp2 = compterep.findById(cpte2 ).get();
		if((cmd.getPrice()>=500)&&(cmd.getPaymentterm()==6) ){

			double montant=((cmd.getPrice()*0.2)+(cmd.getPrice()));

			if ( cp1.getSolde() < montant/6 )
				return ( "Solde insuffisant !" );

			retirer( cpte1, montant/6 );
			verser( cpte2, montant/6 );
			cmd.setPayement(ModePayement.BYFACILITY);
			cmd.setEtat(Etat.ORDERED);
			cmd.setMethod("virement");
			cmd.setDateSend(new Date());
			cmd.setValidpayement(true);
			cp1.setSolde( cp1.getSolde() - (montant/6) );
			cp2.setSolde( cp2.getSolde() + (montant/6) );
			compterep.save(cp1);
			compterep.save(cp2);
			if(cmd.getDateCreation().getTime()-new Date().getTime() ==6480) {
				cmd.setDelivery(d);
				
			}
			comrep.save(cmd);
			return "the invoice total will be increased to 20% and we will take "+" "+ montant/6+" "+"from your account each month";
		}
		else {
			return "you can't pay by facility";
		}	
	}
	//payement in 9 months 
	//@Scheduled(cron="0 0 0 1 * ?", zone="Africa/Tunis")
	@Override	
	public String payin9months(int idcmd ,int cpte1, int cpte2,int deliveryid) {
		Command cmd= comrep.findById(idcmd).get();
		//Bill b = bilrep.findById(idbill).get();
		Delivery d = delivrep.findById(deliveryid).get();
		Compte cp1 = compterep.findById(cpte1 ).get();
		Compte cp2 = compterep.findById(cpte2 ).get();
		if((cmd.getPrice()>=500)&&(cmd.getPaymentterm()==9) ){

			double montant=((cmd.getPrice()*0.3)+(cmd.getPrice()));

			if ( cp1.getSolde() < montant/9 )
				return ( "Solde insuffisant !" );

			retirer( cpte1, montant/9 );
			verser( cpte2, montant/9 );
			cmd.setPayement(ModePayement.BYFACILITY);
			cmd.setEtat(Etat.ORDERED);
			cmd.setMethod("virement");
			cmd.setDateSend(new Date());
			cmd.setValidpayement(true);
			cp1.setSolde( cp1.getSolde() - (montant/9) );
			cp2.setSolde( cp2.getSolde() + (montant/9) );
			compterep.save(cp1);
			compterep.save(cp2);
			if(cmd.getDateCreation().getTime()-new Date().getTime() ==19440) {
				cmd.setDelivery(d);
			}
			comrep.save(cmd);
			return "the invoice total will be increased to 30% and we will take "+" "+ montant/9+" "+"from your account each month";
		}
		else {
			return "you can't pay by facility";
		}	
	}
	//payement in 12 months
//	@Scheduled(cron="0 0 0 1 * ?", zone="Africa/Tunis")
	@Override	
	public String payin12months(int idcmd ,int cpte1, int cpte2,int deliveryid) {
		Command cmd= comrep.findById(idcmd).get();
		//Bill b = bilrep.findById(idbill).get();
		Delivery d = delivrep.findById(deliveryid).get();
		Compte cp1 = compterep.findById(cpte1 ).get();
		Compte cp2 = compterep.findById(cpte2 ).get();
		if((cmd.getPrice()>=500)&&(cmd.getPaymentterm()==12) ){

			double montant=((cmd.getPrice()*0.4)+(cmd.getPrice()));

			if ( cp1.getSolde() < montant/12 )
				return ( "Solde insuffisant !" );

			retirer( cpte1, montant/12 );
			verser( cpte2, montant/12 );
			cmd.setPayement(ModePayement.BYFACILITY);
			cmd.setEtat(Etat.ORDERED);
			cmd.setMethod("virement");
			cmd.setDateSend(new Date());
			cmd.setValidpayement(true);
			cp1.setSolde( cp1.getSolde() - (montant/12) );
			cp2.setSolde( cp2.getSolde() + (montant/12) );
			compterep.save(cp1);
			compterep.save(cp2);
			if(cmd.getDateCreation().getTime()-new Date().getTime() ==58320) {
				cmd.setDelivery(d);
			}
			comrep.save(cmd);
			return "the invoice total will be increased to 40% and we will take "+" "+ montant/12+" "+"from your account each month";
		}
		else {
			return "you can't pay by facility";
		}	
	}

	@Override
	public String  addprogrammefidelite (int idfidel ) {

		ProgrammeFidelité pf =pfrep.findById(idfidel).get();
		if(pf.getEtat()==Etatfidelite.ACTIF) {
			if(pf.getType()==Typefidelite.palierachat) {

				int nbpoint =pf.getCommand().getCart().getUser().getNbrpoint();
				Double dnum=Double.valueOf(nbpoint*0.1);
				pf.getCommand().getCart().getUser().setPointconverti(dnum);
				pf.getCommand().getCart().getUser().setNbrpoint(0);
				userep.save(pf.getCommand().getCart().getUser());
				return "you have"+" "+nbpoint+" "+"which are converted into "+dnum+" "+pf.getCommand().getCurrency();
			}
			if(pf.getType()==Typefidelite.seuilachat) {
				if((pf.getCommand().getPrice()>50)&&(pf.getCommand().getEtat()==Etat.ORDERED)) {
					pf.getCommand().getCart().getUser().setNbrpoint(100);

					userep.save(pf.getCommand().getCart().getUser());
					return "you have 100 point in your card";}
				if((pf.getCommand().getPrice()<50)&&(pf.getCommand().getEtat()==Etat.ORDERED)) {
					pf.getCommand().getCart().getUser().setNbrpoint(20);

					userep.save(pf.getCommand().getCart().getUser());
					return "you have 20 point in your card";
				}}
			if(pf.getType()==Typefidelite.reductionachat){
				pf.getCommand().setReduction((int) (pf.getCommand().getCart().getUser().getNbrpoint()*0.1));
				pf.getCommand().getCart().getUser().setNbrpoint(0);
				comrep.save(pf.getCommand());
				return "you have a reduction "+pf.getCommand().getReduction()+" "+"%";
			}




		}
		return "your loyalty program is deactivated";
	}
	//@Scheduled(cron="0 0 0 1 * ?", zone="Africa/Tunis")
	@Override
	public String paymentbyfidelite(int cartid , int cpte2,int deliveryid) {
		Delivery d = delivrep.findById(deliveryid).get();
		Cart c = cartrep.findById(cartid).get();
		Compte cp2 = compterep.findById(cpte2 ).get();

		if(c.getUser().getPointconverti()>=c.getCommand().getPrice()) {
			c.getCommand().setPayement(ModePayement.BYFIDELITE);
			if((cp2.getUser().getRole().getType()==Roletype.MANAGERSALE))  {
				comrep.save(c.getCommand());


				c.getUser().setPointconverti(c.getUser().getPointconverti()-c.getCommand().getPrice());

				userep.save(c.getUser());

				double montant =c.getCommand().getPrice();
				//retirer( cpte1, montant/12 );
				verser( cpte2, montant );

				//	cp1.setSolde( cp1.getSolde() - (montant/12) );
				cp2.setSolde( cp2.getSolde() + (montant) );
				//compterep.save(cp1);
				compterep.save(cp2);

				c.getCommand().setEtat(Etat.ORDERED);
				c.getCommand().setMethod("virement");
				c.getCommand().setDateSend(new Date());
				c.getCommand().setValidpayement(true);


				return "you pay "+" "+c.getUser().getPointconverti()+" "+"by loyalty";
			}

		}return "you can't pay by loyalty";}
	
	@Override
	public void performCommandCleanup() {
		Command c = new Command();
		if(c.getEtat()==Etat.CANCELED) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -360);
		java.sql.Date oneYear = new java.sql.Date(cal.getTimeInMillis());
		comrep.removeOlderThan(oneYear);
		}
	}
	@Override
	public String reductionsurcommande(int idcart) {
		Cart c = cartrep.findById(idcart).get();
		
		if(c.getCommand().getPayement()==ModePayement.ENLIGNE) {
			c.getCommand().setReduction(5);
		}
		if(c.getCommand().getPrice()>=500) {
			c.getCommand().setReduction(10);
		}
		comrep.save(c.getCommand());
		//comrep.getAllCommandByUser(idc)
		return "you can benefit from reduction";
	}
}
//valider commande 

	/*@Transactional
	public void saveCommande(int idc,int cpte1, int cpte2) {
		Command cmd = comrep.findById(idc).get();
		if(cmd.getPayement()==ModePayement.BYFACILITY && cmd.getPaymentterm()==3) {
			this.payinthreemonths(idc,cpte1, cpte2);
			cmd.setValidpayement(true);
			cmd.setEtat(Etat.ORDERED);
			
		}
		User u =userep.findById(userid).get();
		cmd.setPrice(AmountCommand);
		//cmd.setUser(u);
		cmd.setCart(cart);
		cmd.setPayement(payement);
		cmd.setValidpayement(validpayement);
		cmd.setNumcommand(generatenumcommand());
		cmd.setEtat(etat.COMPLETE); 
		cmd.setDateCreation(new Date());
		cmd.setDateSend(new Date());
		cmd.setTva(tva);
		comrep.save(cmd);

	}*/
/*	@Override
public void affecterCommandAUser(int userId, int commandId) {
	Command cmd = comrep.findById(commandId).get();
	User u =userep.findById(userId).get();
	cmd.setUser(u);
	comrep.save(cmd);

}
 */
/*public void creercommande() {

commande=new Command();
//commande.setUser(user);
commande.setDateCreation(new Date());
commande.setDateSend(new Date());
commande.setNumcommand(generatenumcommand());
comrep.save(commande);
}*/
/*

@Override
public ResponseEntity<Object> AjouterCommand(Command c) {

	Command savedc=comrep.save(c);
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(savedc.getIdcommand()).toUri();

	return ResponseEntity.ok("Order is successfully added") ;
}*/

/*	@Override
public ResponseEntity<String> addOrUpdateCommand(Command c) {

	Command savedc=comrep.save(c);
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(savedc.getIdcommand()).toUri();

	return ResponseEntity.ok("Order is valid") ;
}
*/
