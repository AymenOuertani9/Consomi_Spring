package tn.esprit.pidev.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Compte;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.Operation;
import tn.esprit.pidev.entities.Retrait;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.entities.Versement;
import tn.esprit.pidev.repository.ICommandRepository;
import tn.esprit.pidev.repository.ICompteRepository;
import tn.esprit.pidev.repository.OperationRepository;

@Service
public class OperationService implements IOperationService{
@Autowired
OperationRepository oprep;
@Autowired
ICompteRepository comrep;
@Autowired
ICommandRepository comandrep;

@Transactional // si tous ce passe bien la transaction et faite
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
        return true;
	}
	
	@Override
	public boolean virement(int cpte1, int cpte2, double montant,int idc) {
		Command cmd = comandrep.findById(idc).get();
		Etat etat =cmd.getEtat();
		if((etat==Etat.CANCELED)&&(cmd.getValidpayement()==true)&&(cmd.getDateSend().getTime()-new Date().getTime()<=24)) {
		retirer( cpte1, montant );
        verser( cpte2, montant );
        return true;
		}
        return false;
	}
	


	//les fonctionalites ena9sin 
	//@schedchule pour les paniers abondonnés
	//proposition de produit au choix de panier 
	
	
	//tkml f payement w facture 
	//currency
	//zid des api okhrin de payement 
	//les points fidelites
	//précommander
	//exporter les achats
}
