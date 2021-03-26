package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor

public class Commentaire implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idcomment;
private String description;
private int nblike;
@ManyToOne
private Publication publication;
@ManyToOne
private UserConsomi user;
@NotNull
private LocalDateTime dateTimeOfComment = LocalDateTime.now();


public Commentaire() {
	super();
	// TODO Auto-generated constructor stub
}






public Commentaire(int idcomment, String description, Publication publication, UserConsomi user,
		LocalDateTime dateTimeOfComment,int nblike) {
	super();
	this.idcomment = idcomment;
	this.description = description;
	this.publication = publication;
	this.user = user;
	this.dateTimeOfComment = dateTimeOfComment;
    this.nblike=nblike;
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



public UserConsomi getUser() {
	return user;
}



public void setUser(UserConsomi user) {
	this.user = user;
}






public LocalDateTime getDateTimeOfComment() {
	return dateTimeOfComment;
}






public void setDateTimeOfComment(LocalDateTime dateTimeOfComment) {
	this.dateTimeOfComment = dateTimeOfComment;
}






public int getNblike() {
	return nblike;
}






public void setNblike(int nblike) {
	this.nblike = nblike;
}






}
