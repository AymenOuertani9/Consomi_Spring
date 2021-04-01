package tn.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Remarque implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idnote;
private String content;
@ManyToOne
private Command comande;
@ManyToOne
private User user;
public int getIdnote() {
	return idnote;
}
public void setIdnote(int idnote) {
	this.idnote = idnote;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Command getComande() {
	return comande;
}
public void setComande(Command comande) {
	this.comande = comande;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Remarque(int idnote, String content, Command comande, User user) {
	super();
	this.idnote = idnote;
	this.content = content;
	this.comande = comande;
	this.user = user;
}
public Remarque() {
	super();
}

}
