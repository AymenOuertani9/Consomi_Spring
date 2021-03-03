package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publication implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idpub;
private String topic;
@OneToMany(mappedBy = "publication")
private List <Commentaire> commentaire;
@OneToMany(mappedBy = "publication")
private List<Rating>rating;


public Publication() {
	super();
	// TODO Auto-generated constructor stub
}
public Publication(String topic, List<Commentaire> commentaire, List<Rating> rating) {
	super();
	this.topic = topic;
	this.commentaire = commentaire;
	this.rating = rating;
}
public int getIdpub() {
	return idpub;
}
public void setIdpub(int idpub) {
	this.idpub = idpub;
}
public String getTopic() {
	return topic;
}
public void setTopic(String topic) {
	this.topic = topic;
}
public List<Commentaire> getCommentaire() {
	return commentaire;
}
public void setCommentaire(List<Commentaire> commentaire) {
	this.commentaire = commentaire;
}
public List<Rating> getRating() {
	return rating;
}
public void setRating(List<Rating> rating) {
	this.rating = rating;
}



}
