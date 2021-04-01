package tn.esprit.pidev.service;

import java.util.List;

import tn.esprit.pidev.entities.Compte;



public interface IcompteService {
	public List<Compte>getCompteByIduser(int iduser);
	public Compte getCompteById(int compteId);
	
	public Compte AjouterCompte(Compte c);
	
	public void deleteCompteById(int compteId);
	//public List<Compte> getAllComptes();
	
	public int addOrUpdateCompte(Compte c);
	
	public void ajouteretaffecterCompteAUser(Compte c, int userId);
	

}
