package tn.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDelivery;
	private float weight;
	private float shippingCoast;
	private String etat;
	private String description;
	private String adress;
	private String region;
	private String city;
	
	
	@ManyToOne
	private DeliveryMan deliveryMan;
	@OneToOne
	private Command commande;
	
	/*------------------------------------------------------------------------------------------------*/
	@Override
	public String toString() {
		return "Delivery [idDelivery=" + idDelivery + ", weight=" + weight + ", shippingCoast=" + shippingCoast
				+ ", etat=" + etat + ", description=" + description + ", adress=" + adress + ", region=" + region
				+ ", city=" + city + ", deliveryMan=" + deliveryMan + ", commande=" + commande + "]";
	}
	/*------------------------------------------------------------------------------------------------*/
	public int getIdDelivery() {
		return idDelivery;
	}
	public void setIdDelivery(int idDelivery) {
		this.idDelivery = idDelivery;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getShippingCoast() {
		return shippingCoast;
	}
	public void setShippingCoast(float shippingCoast) {
		this.shippingCoast = shippingCoast;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		adress = adress;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		region = region;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		city = city;
	}
	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}
	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}
	public Command getCommande() {
		return commande;
	}
	public void setCommande(Command commande) {
		this.commande = commande;
	}
	/*------------------------------------------------------------------------------------------------*/
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*------------------------------------------------------------------------------------------------*/
	public Delivery(String description, String adress, String region, String city, DeliveryMan deliveryMan,
			Command commande) {
		super();
		this.description = description;
		this.adress = adress;
		this.region = region;
		this.city = city;
		this.deliveryMan = deliveryMan;
		this.commande = commande;
	}
	
	
	

}
