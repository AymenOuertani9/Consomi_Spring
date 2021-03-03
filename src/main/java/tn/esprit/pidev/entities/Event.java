package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Event implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idEvent;
private String title;
@Temporal(TemporalType.DATE)
private Date date;
@Temporal(TemporalType.TIME)
private Date hour;
private String address;
private String description;
private String image;
private int views;
private int numberOfPlaces;
private boolean status;
//private float priceticket;

@Enumerated(EnumType.STRING)
private CategoryEvent categoryEvent;

@OneToMany(mappedBy = "event", cascade=CascadeType.ALL)
private List<Donation> donations;

@OneToMany(mappedBy = "event", cascade=CascadeType.ALL)
private List<Advertisement>advertisements;
@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
private Jackpot jackpot;
@OneToMany(cascade= CascadeType.ALL, mappedBy= "event")
private List<Participation> participations;


public Event() {
	
	}


public Event(int idEvent, String title, Date date, Date hour, String address, String description, String image,
		int views, int numberOfPlaces, boolean status, CategoryEvent categoryEvent, List<Donation> donations,
		List<Advertisement> advertisements, Jackpot jackpot, List<Participation> participations) {
	super();
	this.idEvent = idEvent;
	this.title = title;
	this.date = date;
	this.hour = hour;
	this.address = address;
	this.description = description;
	this.image = image;
	this.views = views;
	this.numberOfPlaces = numberOfPlaces;
	this.status = status;
	this.categoryEvent = categoryEvent;
	this.donations = donations;
	this.advertisements = advertisements;
	this.jackpot = jackpot;
	this.participations = participations;
}


public Event(String title, Date date, Date hour, String address, String description, String image, int views,
		int numberOfPlaces, boolean status, CategoryEvent categoryEvent, List<Donation> donations,
		List<Advertisement> advertisements, Jackpot jackpot, List<Participation> participations) {
	super();
	this.title = title;
	this.date = date;
	this.hour = hour;
	this.address = address;
	this.description = description;
	this.image = image;
	this.views = views;
	this.numberOfPlaces = numberOfPlaces;
	this.status = status;
	this.categoryEvent = categoryEvent;
	this.donations = donations;
	this.advertisements = advertisements;
	this.jackpot = jackpot;
	this.participations = participations;
}


public int getIdEvent() {
	return idEvent;
}


public void setIdEvent(int idEvent) {
	this.idEvent = idEvent;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public Date getDate() {
	return date;
}


public void setDate(Date date) {
	this.date = date;
}


public Date getHour() {
	return hour;
}


public void setHour(Date hour) {
	this.hour = hour;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getImage() {
	return image;
}


public void setImage(String image) {
	this.image = image;
}


public int getViews() {
	return views;
}


public void setViews(int views) {
	this.views = views;
}


public int getNumberOfPlaces() {
	return numberOfPlaces;
}


public void setNumberOfPlaces(int numberOfPlaces) {
	this.numberOfPlaces = numberOfPlaces;
}


public boolean isStatus() {
	return status;
}


public void setStatus(boolean status) {
	this.status = status;
}


public CategoryEvent getCategoryEvent() {
	return categoryEvent;
}


public void setCategoryEvent(CategoryEvent categoryEvent) {
	this.categoryEvent = categoryEvent;
}


public List<Donation> getDonations() {
	return donations;
}


public void setDonations(List<Donation> donations) {
	this.donations = donations;
}


public List<Advertisement> getAdvertisements() {
	return advertisements;
}


public void setAdvertisements(List<Advertisement> advertisements) {
	this.advertisements = advertisements;
}


public Jackpot getJackpot() {
	return jackpot;
}


public void setJackpot(Jackpot jackpot) {
	this.jackpot = jackpot;
}


public List<Participation> getParticipations() {
	return participations;
}


public void setParticipations(List<Participation> participations) {
	this.participations = participations;
}


@Override
public String toString() {
	return "Event [idEvent=" + idEvent + ", title=" + title + ", date=" + date + ", hour=" + hour + ", address="
			+ address + ", description=" + description + ", image=" + image + ", views=" + views + ", numberOfPlaces="
			+ numberOfPlaces + ", status=" + status + ", categoryEvent=" + categoryEvent + ", donations=" + donations
			+ ", advertisements=" + advertisements + ", jackpot=" + jackpot + ", participations=" + participations
			+ "]";
}


}