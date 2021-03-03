package tn.esprit.pidev.services;

import java.util.List;

import tn.esprit.pidev.entities.Commentaire;
import tn.esprit.pidev.entities.Publication;

public interface ICommentaireService {
	//public void save(Commentaire commentsDto) ;
	public int ajouterCommentaire(Commentaire commentaire);
	public void mettreAjourCommentaireById(String description ,int idcomment);

	public void deleteCommentaireById(int idpub);
	public List<String> getAllCommentaireJPQL();

}
