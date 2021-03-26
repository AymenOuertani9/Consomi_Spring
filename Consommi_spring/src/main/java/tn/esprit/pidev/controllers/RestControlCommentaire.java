package tn.esprit.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Commentaire;
import tn.esprit.pidev.entities.Dictionnaire;
import tn.esprit.pidev.services.ICommentaireService;
import tn.esprit.pidev.services.IPublicationService;

@RestController
public class RestControlCommentaire {
@Autowired
ICommentaireService cmnt;
@Autowired
IPublicationService puser;

//http://localhost:8085/ajouterCommentaire
@PostMapping("/Publication/{idPub}/{idUser}/ajouterCommentaire")
@ResponseBody
public String addComment(@RequestBody Commentaire cmt,@PathVariable("idPub") int idPub,@PathVariable("idUser") int idUser) 
{
//if(commentaire.getDescription()==null || commentaire.getDescription().isEmpty()) return "The comment is empty";
//cmt.setDescription(cmnt.verifyBadWords(cmt.getDescription()));
if(cmnt.addComment(cmt)=="comment added") {
	puser.assignCommentToPublication(cmt.getIdcomment(),idPub);
		return cmnt.assignCommentToUser(cmt.getIdcomment(), idUser);
	}
	
	return "failed assignment";
}



//http://localhost:8085/deleteCommentaireById/{idcomment}
@DeleteMapping("deleteCommentaireById/{idcomment}") 
@ResponseBody 
public void deleteCommentaireById(@PathVariable("idcomment")int idcomment) {
	cmnt.deleteCommentaireById(idcomment);
	
}
//http://localhost:8085/mettreAjourPublicationById/{id}/{newdescription}
@PutMapping(value ="mettreAjourPublicationById/{id}/{newdescription}") 
@ResponseBody
public void mettreAjourCommentaireById(@PathVariable("newdescription") String description, @PathVariable("id") int idcomment) {	
cmnt.mettreAjourCommentaireById(description, idcomment);
	
}
//http://localhost:8085/user/getAllCommentaireJPQL
@GetMapping(value ="/user/getAllCommentaireJPQL")
@ResponseBody
public List<String> getAllCommentaireJPQL() {
				
return cmnt.getAllCommentaireJPQL();
			}		

//http://localhost:8085/bestcomment
@GetMapping(value ="/bestcomment")
@ResponseBody
public List<Commentaire> getbestcomment() {
				
return cmnt.CommentTop();
			}		
//http://localhost:8085/Forum/Publication/Commentaire/{idCom}
@GetMapping("/Forum/Publication/Commentaire/{idCom}")
public Commentaire getCommentById(@PathVariable int idCom){
	
	return cmnt.findCommentById(idCom);
}




	
}
