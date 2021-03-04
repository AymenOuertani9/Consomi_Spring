package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exchange implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExchange;
	private String description;
	
	@OneToOne
	private Claim claim;
	/*------------------------------------------------------------------------------------------------*/

	public int getIdExchange() {
		return idExchange;
	}

	public void setIdExchange(int idExchange) {
		this.idExchange = idExchange;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}
	/*------------------------------------------------------------------------------------------------*/

	@Override
	public String toString() {
		return "Exchange [idExchange=" + idExchange + ", description=" + description + ", claim=" + claim + "]";
	}
	/*------------------------------------------------------------------------------------------------*/

	public Exchange() {
		super();
	}
	/*------------------------------------------------------------------------------------------------*/

	public Exchange(String description, Claim claim) {
		super();
		this.description = description;
		this.claim = claim;
	}

	


	
	}
	
	
	
	


