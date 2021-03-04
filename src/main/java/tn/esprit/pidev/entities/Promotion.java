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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Promotion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPromotion;
	private String libelle;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String description;
	private long percentage;
	@ManyToOne
	@JsonIgnore
	private Product product;
	public Promotion(int idPromotion, Date startDate, Date endDate, String libelle, String description, long percentage,
			Product product) {
		super();
		this.idPromotion = idPromotion;
		this.startDate = startDate;
		this.endDate = endDate;
		this.libelle = libelle;
		this.description = description;
		this.percentage = percentage;
		this.product = product;
	}
	
	
	
	public Promotion(Date startDate, Date endDate, String libelle, String description, long percentage,
			Product product) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.libelle = libelle;
		this.description = description;
		this.percentage = percentage;
		this.product = product;
	}



	public Promotion() {
		super();
	}



	@Override
	public String toString() {
		return "Promotion [idPromotion=" + idPromotion + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", libelle=" + libelle + ", description=" + description + ", percentage=" + percentage + ", product="
				+ product + "]";
	}



	public int getIdPromotion() {
		return idPromotion;
	}



	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
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



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public long getPercentage() {
		return percentage;
	}



	public void setPercentage(long percentage) {
		this.percentage = percentage;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
