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
	private int iddelivery;
	private int Reference;
	private float weight;
	private String Adress;
	private String Region;
	private String City;
	private String etat;
	private String description;
	private float carnetcarburant ;

	
	@ManyToOne
	private DeliveryMan deliveryman;
	@OneToOne
private Command commande;
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Delivery(int iddelivery, int reference, float weight, String adress, String region, String city, String etat,
			String description, float carnetcarburant ,DeliveryMan deliveryman, Command commande) {
		super();
		this.iddelivery = iddelivery;
		Reference = reference;
		this.weight = weight;
		Adress = adress;
		Region = region;
		City = city;
		this.etat = etat;
		this.description = description;
		this.carnetcarburant = carnetcarburant;
		this.deliveryman = deliveryman;
		this.commande = commande;
	}
	public int getIddelivery() {
		return iddelivery;
	}
	public void setIddelivery(int iddelivery) {
		this.iddelivery = iddelivery;
	}
	public int getReference() {
		return Reference;
	}
	public void setReference(int reference) {
		Reference = reference;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
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
	public float getCarnetcarburant() {
		return carnetcarburant;
	}
	public void setCarnetcarburant(float carnetcarburant) {
		this.carnetcarburant = carnetcarburant;
	}
	public DeliveryMan getDeliveryman() {
		return deliveryman;
	}
	public void setDeliveryman(DeliveryMan deliveryman) {
		this.deliveryman = deliveryman;
	}
	public Command getCommande() {
		return commande;
	}
	public void setCommande(Command commande) {
		this.commande = commande;
	}
	
	

}
