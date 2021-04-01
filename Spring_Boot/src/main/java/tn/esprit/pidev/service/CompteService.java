package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Compte;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.ICompteRepository;
import tn.esprit.pidev.repository.IUserRepository;

@Service
public class CompteService implements IcompteService{
@Autowired
ICompteRepository comrep;
@Autowired
IUserRepository userrep;
	@Override
	public List<Compte> getCompteByIduser(int iduser) {
		
		return comrep.getCompteByIduser(iduser);
	}

	@Override
	public Compte getCompteById(int idcompte) {
		
		return comrep.findById(idcompte).get();
	}

	@Override
	public Compte AjouterCompte(Compte c) {
		
		return comrep.save(c);
	}

	@Override
	public void deleteCompteById(int idcompte) {
		comrep.deleteById(idcompte);
		
	}

	@Override
	public int addOrUpdateCompte(Compte c) {
				 comrep.save(c);
				 return c.getIdcmpt();
	}

	@Override
	public void ajouteretaffecterCompteAUser(Compte c, int iduser) {
		User u = userrep.findById(iduser).get();
		c.setUser(u);
		comrep.save(c);
		
	}

}
