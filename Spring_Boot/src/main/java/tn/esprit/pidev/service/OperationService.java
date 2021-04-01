package tn.esprit.pidev.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Compte;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.ModePayement;
import tn.esprit.pidev.entities.Operation;
import tn.esprit.pidev.entities.Retrait;
import tn.esprit.pidev.entities.Role;

import tn.esprit.pidev.entities.Roletype;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.entities.Versement;
import tn.esprit.pidev.repository.IBillRepository;
import tn.esprit.pidev.repository.ICommandRepository;
import tn.esprit.pidev.repository.ICompteRepository;
import tn.esprit.pidev.repository.IUserRepository;
import tn.esprit.pidev.repository.OperationRepository;

@Service
public class OperationService implements IOperationService{
	@Autowired
	OperationRepository oprep;
	@Autowired
	ICompteRepository comrep;
	@Autowired
	ICommandRepository comandrep;
	@Autowired
	IBillRepository bilrep;
	@Autowired
	IUserRepository userep;
	@Transactional // si tous se passe bien la transaction est faite
	@Override
	public boolean verser(int idcpt, double montant) {
		Compte cp = comrep.findById(idcpt).get();
		Operation o = new Versement();

		// mettre a jour date et montant compte 
		o.setDateOperation( new Date() );
		o.setMontant( montant );
		o.setCompte( cp );


		// sauvgarder l'operation
		oprep.save( o );

		// mettre a jour le solde
		cp.setSolde( cp.getSolde() + montant );
		return true;


	}

	@Override
	public boolean retirer(int idcpt, double montant) {
		Compte cp = comrep.findById(idcpt ).get();
		if ( cp.getSolde() < montant )
			throw new RuntimeException( "Solde insuffisant !" );


		Operation o = new Retrait();
		// mettre a jour date et montant compte 
		o.setDateOperation( new Date() );
		o.setMontant( montant );
		o.setCompte( cp );

		// sauvgarder l'operation
		oprep.save( o );
		// mettre a jour le solde
		cp.setSolde( cp.getSolde() - montant );
		comrep.save(cp);
		return true;
	}
	//remboursement de commande annulé dans le meme jour 
	@Override
	public String virement(int cpte1, int cpte2,int idc) {
		Command cmd = comandrep.findById(idc).get();
		Etat etat =cmd.getEtat();
		double montant=cmd.getPrice();
		if((etat==Etat.CANCELED)&&(cmd.getValidpayement()==true)&&(cmd.getDateCreation().getTime()-new Date().getTime()<=24)) {
			retirer( cpte1, montant );
			verser( cpte2, montant );
			return "your customer is successfully reimbursed";
		}
		return "your customer cannot have a refund";
	}

	//en cas de payement at home le responsable va ajouter le montant dans son compte
	@Override
	public String payamounttoselleraccount(int idcpt,int idc) {

		Command cmd = comandrep.findById(idc).get();
		Compte cp = comrep.findById(idcpt).get();
		if((cmd.getPayement()==ModePayement.HOME)&&(cmd.getCart().getUser().getRole().getType()==Roletype.MANAGERSALE)&&(cmd.getValidpayement()==true))  {

			Operation o = new Versement();
			double	montant =cmd.getDelivery().getBill().getTotalfinal();
			// mettre a jour date et montant compte 
			o.setDateOperation( new Date() );
			o.setMontant( montant );
			o.setCompte( cp );


			// sauvgarder l'operation
			oprep.save( o );
			cp.setSolde( cp.getSolde() + montant);
			comrep.save(cp);
			return "you have paid an amount into your account";
		}
	
		else {

			return "you dont paid any amount ";
		}
	}
	//si le mode de payement est le transfer 
	@Override
	public String paymentbytransfer(int idc,int cpte1, int cpte2) {
		
		Command c = comandrep.findById(idc).get();
		double montant =c.getDelivery().getBill().getTotalfinal();
		if(c.getPayement()==ModePayement.TRANSFER) {
			retirer( cpte1, montant );
			verser( cpte2, montant );
			return "you pay your command by transfer";
		}
		return "you can't pay your command by transfer";
	}

}
