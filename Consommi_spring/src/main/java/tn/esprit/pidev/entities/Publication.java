package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@AllArgsConstructor
//@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Publication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idpub;
private String topic;
@NotNull
private LocalDateTime dateTimeOfPublication = LocalDateTime.now();
private String imageUrl;
private Integer ratingPoints;


private int evaluation;

@OneToMany(mappedBy = "publication")
private List <Commentaire> commentaire;
@OneToMany(mappedBy = "publication")
private List<Rating>rating;
@ManyToOne
UserConsomi publicationUser;
@OneToMany(mappedBy="publication",fetch = FetchType.LAZY,cascade=CascadeType.REMOVE)
List<Commentaire> commentList;



public Publication() {
	super();
	// TODO Auto-generated constructor stub
}



public Publication(int idpub, String topic, LocalDateTime dateTimeOfPublication, String imageUrl, Integer ratingPoints,
		int evaluation, List<Commentaire> commentaire, List<Rating> rating, UserConsomi publicationUser,
		List<Commentaire> commentList) {
	super();
	this.idpub = idpub;
	this.topic = topic;
	this.dateTimeOfPublication = dateTimeOfPublication;
	this.imageUrl = imageUrl;
	this.ratingPoints = ratingPoints;
	this.evaluation = evaluation;
	this.commentaire = commentaire;
	this.rating = rating;
	this.publicationUser = publicationUser;
	this.commentList = commentList;
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

public LocalDateTime getDateTimeOfPublication() {
	return dateTimeOfPublication;
}

public void setDateTimeOfPublication(LocalDateTime dateTimeOfPublication) {
	this.dateTimeOfPublication = dateTimeOfPublication;
}

public String getImageUrl() {
	return imageUrl;
}

public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

public Integer getRatingPoints() {
	return ratingPoints;
}

public void setRatingPoints(Integer ratingPoints) {
	this.ratingPoints = ratingPoints;
}




public int getEvaluation() {
	return evaluation;
}

public void setEvaluation(int evaluation) {
	this.evaluation = evaluation;
}

public UserConsomi getPublicationUser() {
	return publicationUser;
}

public void setPublicationUser(UserConsomi publicationUser) {
	this.publicationUser = publicationUser;
}

public List<Commentaire> getCommentList() {
	return commentList;
}

public void setCommentList(List<Commentaire> commentList) {
	this.commentList = commentList;
}



}
