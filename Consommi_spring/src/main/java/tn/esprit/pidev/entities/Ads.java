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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Ads implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAds;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private String MediaType;
	private String Madia;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date finishDate;
	private String Target;
	private int TargetView_tot;
	@ManyToOne
	//@JsonIgnore
	private Product product;
	
	public Ads() {
		super();
	}
	public Ads(int idAds, Date dateCreation, String mediaType, String madia, Date startDate, Date finishDate,
			String target, int targetView_tot, Product product) {
		super();
		this.idAds = idAds;
		DateCreation = dateCreation;
		MediaType = mediaType;
		Madia = madia;
		this.startDate = startDate;
		this.finishDate = finishDate;
		Target = target;
		TargetView_tot = targetView_tot;
		this.product = product;
	}
	public int getIdAds() {
		return idAds;
	}
	public void setIdAds(int idAds) {
		this.idAds = idAds;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public String getMediaType() {
		return MediaType;
	}
	public void setMediaType(String mediaType) {
		MediaType = mediaType;
	}
	public String getMadia() {
		return Madia;
	}
	public void setMadia(String madia) {
		Madia = madia;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public String getTarget() {
		return Target;
	}
	public void setTarget(String target) {
		Target = target;
	}
	public int getTargetView_tot() {
		return TargetView_tot;
	}
	public void setTargetView_tot(int targetView_tot) {
		TargetView_tot = targetView_tot;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}	
	
}