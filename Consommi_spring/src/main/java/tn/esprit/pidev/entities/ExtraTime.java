package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

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
public class ExtraTime implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExtraTime;
	private Date datEextraTima;
	private int nbrHour;
	
	@ManyToOne
	private DeliveryMan deliveryMan;

	/*------------------------------------------------------------------------------------------------*/

	@Override
	public String toString() {
		return "ExtraTime [idExtraTime=" + idExtraTime + ", datEextraTima=" + datEextraTima + ", nbrHour=" + nbrHour
				+ ", deliveryMan=" + deliveryMan + "]";
	}
	/*------------------------------------------------------------------------------------------------*/

	public int getIdExtraTime() {
		return idExtraTime;
	}

	public void setIdExtraTime(int idExtraTime) {
		this.idExtraTime = idExtraTime;
	}

	public Date getDatEextraTima() {
		return datEextraTima;
	}

	public void setDatEextraTima(Date datEextraTima) {
		this.datEextraTima = datEextraTima;
	}

	public int getNbrHour() {
		return nbrHour;
	}

	public void setNbrHour(int nbrHour) {
		this.nbrHour = nbrHour;
	}

	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}
	/*------------------------------------------------------------------------------------------------*/

	public ExtraTime() {
		super();
		
	}
	/*------------------------------------------------------------------------------------------------*/

	public ExtraTime(Date datEextraTima, int nbrHour, DeliveryMan deliveryMan) {
		super();
		this.datEextraTima = datEextraTima;
		this.nbrHour = nbrHour;
		this.deliveryMan = deliveryMan;
	}
	
	
}
