package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ads implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAds;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private String MediaType;
	private Byte Madia;
	private Date StartDate;
	private Date FinishDate;
	private String Target;
	
	public Ads(int idAds, Date dateCreation, String mediaType, Byte madia, Date startDate, Date finishDate,
			String target) {
		super();
		this.idAds = idAds;
		DateCreation = dateCreation;
		MediaType = mediaType;
		Madia = madia;
		StartDate = startDate;
		FinishDate = finishDate;
		Target = target;
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
	public Byte getMadia() {
		return Madia;
	}
	public void setMadia(Byte madia) {
		Madia = madia;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getFinishDate() {
		return FinishDate;
	}
	public void setFinishDate(Date finishDate) {
		FinishDate = finishDate;
	}
	public String getTarget() {
		return Target;
	}
	public void setTarget(String target) {
		Target = target;
	}
	
	
	
	
}