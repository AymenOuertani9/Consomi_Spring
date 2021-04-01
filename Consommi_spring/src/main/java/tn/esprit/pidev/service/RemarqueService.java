package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Remarque;

import tn.esprit.pidev.repository.ICommandRepository;

import tn.esprit.pidev.repository.IRemarqueRepository;

@Service
public class RemarqueService implements IRemarqueService{
@Autowired
IRemarqueRepository remrep;
@Autowired
ICommandRepository comrep;
	@Override
	public List<Remarque> getRemarqueByIduser(int iduser) {
		
		return remrep.getremarqueByIduser(iduser);
	}

	@Override
	public Remarque getRemarqueById(int remarqId) {
		
		return remrep.findById(remarqId).get();
	}

	@Override
	public Remarque AjouterRemarque(Remarque remarq) {
		
		return remrep.save(remarq);
	}

	@Override
	public void deleteRemarqueById(int remarqueId) {
		
		remrep.deleteById(remarqueId);
		
	}

	@Override
	public List<Remarque> getAllRemarques() {
		
		return remrep.findAll();
	}

	@Override
	public int addOrUpdateRemarque(Remarque remarque) {
		remrep.save(remarque);
		return remarque.getIdnote();
	}

	@Override
	public void ajouteretaffecterRemarqueACommand(Remarque remarque, int cmdId) {
		Command cmd =comrep.findById(cmdId).get(); 
		remarque.setComande(cmd);
		remrep.save(remarque);
		
	}

}
