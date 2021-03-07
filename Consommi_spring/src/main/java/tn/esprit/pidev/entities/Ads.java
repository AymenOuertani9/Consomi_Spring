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
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date finishDate;
	private String Target;
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
		return startDate;
	}
	public void setStartDate(Date startDate) {
		startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		finishDate = finishDate;
	}
	public String getTarget() {
		return Target;
	}
	public void setTarget(String target) {
		Target = target;
	}
	
	
	
	
}