package tn.esprit.pidev.services;

import java.util.List;

import tn.esprit.pidev.entities.Publication;

public interface IPublicationService {
	
	public int ajouterPublication(Publication publication);
	public void mettreAjourPublicationById(String topic ,int idpub);

	public void deletePublicationById(int idpub);
	public List<String> getAllPublicationJPQL();

	


	

}
