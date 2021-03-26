package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
private int iddeliveryman;
private String workzone;
private Boolean availability;
private int Totnbdelivery;
private float premium;

@OneToMany
private List<RequestLeave>requestleave;
@OneToMany
private List<ExtraTime>extratimes;
public DeliveryMan() {
	super();
	// TODO Auto-generated constructor stub
}
public DeliveryMan(int iddeliveryman, String workzone, Boolean availability, int totnbdelivery, float premium, 
		List<RequestLeave> requestleave, List<ExtraTime> extratimes) {
	super();
	this.iddeliveryman = iddeliveryman;
	this.workzone = workzone;
	this.availability = availability;
	Totnbdelivery = totnbdelivery;
	this.premium = premium;
	this.requestleave = requestleave;
	this.extratimes = extratimes;
}
public int getIddeliveryman() {
	return iddeliveryman;
}
public void setIddeliveryman(int iddeliveryman) {
	this.iddeliveryman = iddeliveryman;
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
public int getTotnbdelivery() {
	return Totnbdelivery;
}
public void setTotnbdelivery(int totnbdelivery) {
	Totnbdelivery = totnbdelivery;
}
public float getPremium() {
	return premium;
}
public void setPremium(float premium) {
	this.premium = premium;
}

public List<RequestLeave> getRequestleave() {
	return requestleave;
}
public void setRequestleave(List<RequestLeave> requestleave) {
	this.requestleave = requestleave;
}
public List<ExtraTime> getExtratimes() {
	return extratimes;
}
public void setExtratimes(List<ExtraTime> extratimes) {
	this.extratimes = extratimes;
}





}
