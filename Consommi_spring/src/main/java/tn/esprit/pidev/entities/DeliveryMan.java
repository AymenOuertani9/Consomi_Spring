package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryMan implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDeliveryMan;
	private String workzone;
	private Boolean availability;
	private int totNbDelivery;
	private float premium;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="deliveryMan")
	private Set<ExtraTime> ecxtraTime;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="deliveryMan")
	private Set<RequestLeave> requestLeave;
	
	@OneToOne
	private User user;
	
/*------------------------------------------------------------------------------------------------*/	
	@Override
	public String toString() {
		return "DeliveryMan [idDeliveryMan=" + idDeliveryMan + ", workzone=" + workzone + ", availability="
				+ availability + ", TotNbDelivery=" + totNbDelivery + ", premium=" + premium + ", ecxtraTime="
				+ ecxtraTime + ", requestLeave=" + requestLeave + ", user=" + user + "]";
	}

/*------------------------------------------------------------------------------------------------*/
	public int getIdDeliveryMan() {
		return idDeliveryMan;
	}


	public void setIdDeliveryMan(int idDeliveryMan) {
		this.idDeliveryMan = idDeliveryMan;
	}


	public String getWorkzone() {
		return workzone;
	}


	public void setWorkzone(String workzone) {
		this.workzone = workzone;
	}


	public Boolean getAvailability() {
		return availability;
	}


	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}


	public int getTotNbDelivery() {
		return totNbDelivery;
	}


	public void setTotNbDelivery(int totNbDelivery) {
		totNbDelivery = totNbDelivery;
	}


	public float getPremium() {
		return premium;
	}


	public void setPremium(float premium) {
		this.premium = premium;
	}


	public Set<ExtraTime> getEcxtraTime() {
		return ecxtraTime;
	}


	public void setEcxtraTime(Set<ExtraTime> ecxtraTime) {
		this.ecxtraTime = ecxtraTime;
	}


	public Set<RequestLeave> getRequestLeave() {
		return requestLeave;
	}


	public void setRequestLeave(Set<RequestLeave> requestLeave) {
		this.requestLeave = requestLeave;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	/*------------------------------------------------------------------------------------------------*/
	public DeliveryMan() {
		super();
		
	}
/*------------------------------------------------------------------------------------------------*/

	public DeliveryMan(String workzone, User user) {
		super();
		this.workzone = workzone;
		this.user = user;
	}
	
	
	
	
	
	
	
}
