package tn.esprit.pidev.entities;



import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "participation")
public class Participation implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@EmbeddedId
	private ParticipationPK participationPK;
	private float price;
	
	private String participationDate;

	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "iduser", insertable = false, updatable = false)

	private UserConsomi user;

	@ManyToOne
	@JoinColumn(name = "idEvent", referencedColumnName = "idEvent", insertable = false, updatable = false)
	private Event event;

	public Participation() {
		super();
	}

	public Participation(ParticipationPK participationPK, float price, String participationDate, UserConsomi user,
			Event event) {
		super();
		this.participationPK = participationPK;
		this.price = price;
		this.participationDate = participationDate;
		this.user = user;
		this.event = event;
	}

	public ParticipationPK getParticipationPK() {
		return participationPK;
	}

	public void setParticipationPK(ParticipationPK participationPK) {
		this.participationPK = participationPK;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getParticipationDate() {
		return participationDate;
	}

	public void setParticipationDate(String participationDate) {
		this.participationDate = participationDate;
	}

	public UserConsomi getUser() {
		return user;
	}

	public void setUser(UserConsomi user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Participation [participationPK=" + participationPK + ", price=" + price + ", participationDate="
				+ participationDate + ", user=" + user + ", event=" + event + "]";
	}
}

	
	
	
	
	
