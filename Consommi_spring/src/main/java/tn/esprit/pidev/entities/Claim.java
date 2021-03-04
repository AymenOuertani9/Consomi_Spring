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
public class Claim implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idclaim;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateClaim;
	private String etat;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Product product;
	
	@OneToOne(mappedBy="claim")
	private Repair repair;
	
	@OneToOne(mappedBy="claim")
	private Exchange exchange;
	
	@OneToOne(mappedBy="claim")
	private Refund refund;
	
	/*------------------------------------------------------------------------------------------------*/
	public int getIdclaim() {
		return idclaim;
	}

	public void setIdclaim(int idclaim) {
		this.idclaim = idclaim;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateClaim() {
		return dateClaim;
	}

	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Repair getRepair() {
		return repair;
	}

	public void setRepair(Repair repair) {
		this.repair = repair;
	}

	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	public Refund getRefund() {
		return refund;
	}

	public void setRefund(Refund refund) {
		this.refund = refund;
	}
	/*------------------------------------------------------------------------------------------------*/
	@Override
	public String toString() {
		return "Claim [idclaim=" + idclaim + ", description=" + description + ", dateClaim=" + dateClaim + ", etat="
				+ etat + ", user=" + user + ", product=" + product + ", repair=" + repair + ", exchange=" + exchange
				+ ", refund=" + refund + "]";
	}
	/*------------------------------------------------------------------------------------------------*/
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}	
	/*------------------------------------------------------------------------------------------------*/

	public Claim(String description, Date dateClaim, User user, Product product) {
		super();
		this.description = description;
		this.dateClaim = dateClaim;
		this.user = user;
		this.product = product;
	}
	

	
	
	

}
