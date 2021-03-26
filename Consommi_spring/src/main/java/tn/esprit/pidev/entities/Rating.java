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
public class Rating implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrating;
	private int nbretoile;
	//private int like;

	@ManyToOne
	private UserConsomi user;
	@ManyToOne
	private Publication publication;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(int idrating, int nbretoile , UserConsomi user, Publication publication) {
		super();
		this.idrating = idrating;
		this.nbretoile = nbretoile;
		//this.like =like;
		this.user = user;
		this.publication = publication;
	}
	public int getIdrating() {
		return idrating;
	}
	public void setIdrating(int idrating) {
		this.idrating = idrating;
	}
	public int getNbretoile() {
		return nbretoile;
	}
	public void setNbretoile(int nbretoile) {
		this.nbretoile = nbretoile;
	}
	public UserConsomi getUser() {
		return user;
	}
	public void setUser(UserConsomi user) {
		this.user = user;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	
	
	
}
