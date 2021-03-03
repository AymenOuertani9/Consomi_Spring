package tn.esprit.pidev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Publication;
import tn.esprit.pidev.repositories.PublicationRepository;
@Service
public class PublicationServiceImpl implements IPublicationService {
	
	@Autowired
	PublicationRepository pubrep;

	@Override
	public int ajouterPublication(Publication publication) {
		pubrep.save(publication);
		return publication.getIdpub();		
	}

	

	@Override
	public void deletePublicationById(int idpub) {
		Publication pubde = pubrep.findById(idpub).get();
		pubrep.delete(pubde);		
	}

	@Override
	public List<String> getAllPublicationJPQL() {
		
 	return pubrep.publication();
	}

	@Override
	public void mettreAjourPublicationById(String topic, int pubId) {
		pubrep.mettreAjourtopicByPublication(topic, pubId);		
	}
	
	
}
