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
import tn.esprit.pidev.services.ICommentaireService;

@RestController
public class RestControlCommentaire {
@Autowired
ICommentaireService cmnt;

@PostMapping("/user/ajouterCommentaire")
@ResponseBody()
public Commentaire ajouterCommentaire(@RequestBody() Commentaire commentaire)
{

	cmnt.ajouterCommentaire(commentaire);
	return commentaire;
}


@DeleteMapping("/user/deleteCommentaireById/{idcomment}") 
@ResponseBody 
public void deleteCommentaireById(@PathVariable("idcomment")int idcomment) {
	cmnt.deleteCommentaireById(idcomment);
	
}

@PutMapping(value ="user/mettreAjourPublicationById/{id}/{newdescription}") 
@ResponseBody
public void mettreAjourCommentaireById(@PathVariable("newdescription") String description, @PathVariable("id") int idcomment) {	
cmnt.mettreAjourCommentaireById(description, idcomment);
	
}

@GetMapping(value ="/user/getAllCommentaireJPQL")
@ResponseBody
public List<String> getAllCommentaireJPQL() {
				
return cmnt.getAllCommentaireJPQL();
			}	






	
}
