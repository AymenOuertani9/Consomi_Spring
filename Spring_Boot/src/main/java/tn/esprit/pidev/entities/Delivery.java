package tn.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity

public class Delivery implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddelivery;
	private int Reference;
	private float weight;
	private String Adress;
	private String Region;
	private String City;
	@Enumerated(EnumType.STRING)
	private EtatDelivry etat;
	private String description;
	private double fraislivraison;
	@ManyToOne
	private DeliveryMan deliveryman;
	@OneToOne(mappedBy = "delivery")
	private Command commande;
	@OneToOne(mappedBy = "delivery")
	private Bill bill;

	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
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

	public EtatDelivry getEtat() {
		return etat;
	}
	public void setEtat(EtatDelivry etat) {
		this.etat = etat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public double getFraislivraison() {
		return fraislivraison;
	}
	public void setFraislivraison(double fraislivraison) {
		this.fraislivraison = fraislivraison;
	}
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Delivery(int iddelivery, int reference, float weight, String adress, String region, String city,
			EtatDelivry etat, String description, double fraislivraison, DeliveryMan deliveryman, Command commande) {
		super();
		this.iddelivery = iddelivery;
		Reference = reference;
		this.weight = weight;
		Adress = adress;
		Region = region;
		City = city;
		this.etat = etat;
		this.description = description;
		this.fraislivraison = fraislivraison;
		this.deliveryman = deliveryman;
		this.commande = commande;
	}


}
