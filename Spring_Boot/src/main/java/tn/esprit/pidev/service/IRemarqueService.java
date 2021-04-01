package tn.esprit.pidev.service;

import java.util.List;

import tn.esprit.pidev.entities.Remarque;



public interface IRemarqueService {
	public List<Remarque>getRemarqueByIduser(int iduser);
	public Remarque getRemarqueById(int remarqId);
	
	public String AjouterRemarque(Remarque remarq);
	
	public void deleteRemarqueById(int remarqueId);
	public List<Remarque> getAllRemarques();
	
	public int addOrUpdateRemarque(Remarque remarque);
	
	public void ajouteretaffecterRemarqueACommand(Remarque remarque, int cmdId);
	
	
}
