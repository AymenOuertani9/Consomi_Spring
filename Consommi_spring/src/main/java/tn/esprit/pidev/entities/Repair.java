package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Repair implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRepair;
	private float coast;
	private String description;
	
	@OneToOne
	private Claim claim;
	/*------------------------------------------------------------------------------------------------*/

	public int getIdRepair() {
		return idRepair;
	}

	public void setIdRepair(int idRepair) {
		this.idRepair = idRepair;
	}

	public float getCoast() {
		return coast;
	}

	public void setCoast(float coast) {
		this.coast = coast;
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
		return "Repair [idRepair=" + idRepair + ", coast=" + coast + ", description=" + description + ", claim=" + claim
				+ "]";
	}
	/*------------------------------------------------------------------------------------------------*/

	public Repair() {
		super();
		
	}	
	/*------------------------------------------------------------------------------------------------*/

	public Repair(float coast, String description, Claim claim) {
		super();
		this.coast = coast;
		this.description = description;
		this.claim = claim;
	}
	

	
	
	


}
