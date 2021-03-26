package tn.esprit.pidev.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Commentaire;
import tn.esprit.pidev.entities.Publication;
import tn.esprit.pidev.entities.Rating;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repositories.CommentaireRepository;
import tn.esprit.pidev.repositories.PublicationRepository;
import tn.esprit.pidev.repositories.RatingRepository;
import tn.esprit.pidev.repositories.UserRepository;

@Service
public class CommentaireService implements ICommentaireService{
@Autowired
PublicationRepository pu;
@Autowired
UserRepository us;

@Autowired
CommentaireRepository cmnt ;
@Autowired
RatingRepository var3;





@Override
public String addComment(Commentaire cmt) {
	
	//verification des mots dans le  Dictionnaire de mots interdits
	if(cmt.getDescription().isEmpty()) return "you need to put the description";
	//cmt.setCommentDate(new Date());
	cmnt.save(cmt);
	return "comment added";
}



//@Override
//public int ajouterCommentaire(Commentaire commentaire) {
//	cmnt.save(commentaire);
//	return commentaire.getIdcomment();		
//}
@Override
public void mettreAjourCommentaireById(String description, int commentId) {
cmnt.mettreAjourdescriptionByCommentaire(description, commentId);	
}
@Override
public void deleteCommentaireById(int idcomment) {
	Commentaire com = cmnt.findById(idcomment).get();
	cmnt.delete(com);		
	
}
@Override
public List<String> getAllCommentaireJPQL() {
	return cmnt.Commentaire();	 
}

@Override
public List<Commentaire> CommentTop() {
	// TODO Auto-generated method stub
	return cmnt.CommentTop();
}

@Override
public String assignCommentToUser(int idComment, int idUser) {
	// TODO Auto-generated method stub
	
	Commentaire cmt = cmnt.findById(idComment).orElse(null);
	UserConsomi user = us.findById( idUser).orElse(null);
	
	
	if(cmt !=null && user !=null) {
			cmt.setUser(user);
			cmnt.save(cmt);
			return "Comment Affected to "+user.getIduser();
	}else
			return "Comment Doesn't affected";
	
}



@Override
public int ajouterCommentaire(Commentaire commentaire) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public List<Commentaire> findCommentsByPublication(int idPub) {
	// TODO Auto-generated method stub
	Publication pub = pu.findById(idPub).orElse(null);
	return pub.getCommentList();
}
@Override
public Commentaire findCommentById(int idCom) {
	// TODO Auto-generated method stub
	return cmnt.findById(idCom).orElse(null);
}




}
