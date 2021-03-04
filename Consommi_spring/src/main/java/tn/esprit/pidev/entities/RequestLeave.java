package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLeave implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRequestLeave;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String etat;
	private String description;

	@ManyToOne
	private DeliveryMan deliveryMan;
	
	/*------------------------------------------------------------------------------------------------*/

	@Override
	public String toString() {
		return "RequestLeave [idRequestLeave=" + idRequestLeave + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", etat=" + etat + ", description=" + description + ", deliveryMan=" + deliveryMan + "]";
	}
	/*------------------------------------------------------------------------------------------------*/

	public int getIdRequestLeave() {
		return idRequestLeave;
	}

	public void setIdRequestLeave(int idRequestLeave) {
		this.idRequestLeave = idRequestLeave;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}
	
	/*------------------------------------------------------------------------------------------------*/

	public RequestLeave() {
		super();
	}
	/*------------------------------------------------------------------------------------------------*/

	public RequestLeave(Date startDate, Date endDate, String description, DeliveryMan deliveryMan) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.deliveryMan = deliveryMan;
	}

	
	


}
