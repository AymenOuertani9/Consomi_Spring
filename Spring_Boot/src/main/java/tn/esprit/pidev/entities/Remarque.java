package tn.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Entity
@Valid
public class Remarque implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idnote;
	@Size(min = 4,message = " Content should have atleast 4 characters")
	private String content;
	@ManyToOne
	private Command comande;
	
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
	
	public Remarque(int idnote, String content, Command comande) {
		super();
		this.idnote = idnote;
		this.content = content;
		this.comande = comande;
		
	}
	public Remarque() {
		super();
	}

}
