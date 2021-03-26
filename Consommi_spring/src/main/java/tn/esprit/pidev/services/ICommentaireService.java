package tn.esprit.pidev.services;

import java.util.List;

import tn.esprit.pidev.entities.Commentaire;
import tn.esprit.pidev.entities.Publication;
import tn.esprit.pidev.entities.Rating;

public interface ICommentaireService {
	//public void save(Commentaire commentsDto) ;
	public String addComment(Commentaire cmt);
	public int ajouterCommentaire(Commentaire commentaire);
	public void mettreAjourCommentaireById(String description ,int idcomment);

	public void deleteCommentaireById(int idpub);
	public List<String> getAllCommentaireJPQL();
	public List<Commentaire> CommentTop();
	//public Rating addEv(Rating e, Integer id) ;
	public String assignCommentToUser(int idComment, int idUser) ;
	public List<Commentaire> findCommentsByPublication(int idPub);
	public Commentaire findCommentById(int idCom);


}
