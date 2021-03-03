package tn.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idcomment;
private String description;
@ManyToOne
private Publication publication;
@ManyToOne
private User user;



public Commentaire() {
	super();
	// TODO Auto-generated constructor stub
}



public Commentaire(String description, Publication publication, User user) {
	super();
	this.description = description;
	this.publication = publication;
	this.user = user;
}



public int getIdcomment() {
	return idcomment;
}



public void setIdcomment(int idcomment) {
	this.idcomment = idcomment;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public Publication getPublication() {
	return publication;
}



public void setPublication(Publication publication) {
	this.publication = publication;
}



public User getUser() {
	return user;
}



public void setUser(User user) {
	this.user = user;
}






}
