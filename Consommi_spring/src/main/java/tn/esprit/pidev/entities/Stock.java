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
	private float Quantity;
	@ManyToOne
	private UserConsomi user;
	@ManyToMany
	private List<Product> products;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(int idstock, Date dateCreation, float quantity, UserConsomi user, List<Product> products) {
		super();
		this.idstock = idstock;
		DateCreation = dateCreation;
		Quantity = quantity;
		this.user = user;
		this.products = products;
	}
	
	
	

}
