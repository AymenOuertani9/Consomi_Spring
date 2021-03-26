package tn.esprit.pidev.services;

import java.nio.file.Path;
import java.util.List;

import tn.esprit.pidev.entities.Publication;
import tn.esprit.pidev.entities.Rating;

public interface IPublicationService {
	
	public int ajouterPublication(Publication publication);
	public String addPublication (Publication pub,int idUser);
	public void mettreAjourPublicationById(String topic ,int idpub);

	public void deletePublicationById(int idpub);
	public List<String> getAllPublicationJPQL();
	public List<Publication> Subjectnew() ;
	public List<Publication> search(String topic);
	public List<Publication> searchbest();
	public Rating addEv(Rating e, Integer id) ;
	public void assignCommentToPublication(int idComment, int idPublication) ;
	public long getFileSize(Path path);
	public Publication getPublicationById(int id,int idUser) ;
	public String updatePublication(Publication pub);
	public List<Publication> findPublicationsByIdUser(int idUser);
}
