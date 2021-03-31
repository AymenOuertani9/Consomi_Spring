package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idstock;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private float quantity;
	@ManyToOne
	private User user;
	@ManyToMany
	private List<Command> commande;
	@ManyToMany(mappedBy = "stocks")
	private List<Product> products;
	
	public int getIdstock() {
		return idstock;
	}
	public void setIdstock(int idstock) {
		this.idstock = idstock;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		quantity = quantity;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Command> getCommandes() {
		return commande;
	}
	public void setCommandes(List<Command> commandes) {
		commande = commandes;
	}
	
	
	
	

}
