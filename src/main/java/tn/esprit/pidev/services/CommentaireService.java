package tn.esprit.pidev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Commentaire;
import tn.esprit.pidev.entities.Publication;
import tn.esprit.pidev.repositories.CommentaireRepository;
import tn.esprit.pidev.repositories.PublicationRepository;
import tn.esprit.pidev.repositories.UserRepository;

@Service
public class CommentaireService implements ICommentaireService{
@Autowired
PublicationRepository pu;
@Autowired
UserRepository us;

@Autowired
CommentaireRepository cmnt ;


//	@Override
//	public void save(Commentaire commentsDto) {
//		  Optional<Publication> publication = pu.findById (commentsDto .getIdcomment());
//		//  Commentaire comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
//		  
//				  
////				  
////				  .orElseThrow(()-> new PostNotFoundException(commentsDto.getIdcomment().toString()));
////	        
////		  Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
////	        commentRepository.save(comment);
////
////	        String message = mailContentBuilder.build(authService.getCurrentUser() + " posted a comment on your post." + POST_URL);
////	        sendCommentNotification(message, post.getUser());
//	    }
@Override
public int ajouterCommentaire(Commentaire commentaire) {
	cmnt.save(commentaire);
	return commentaire.getIdcomment();		
}
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

}
