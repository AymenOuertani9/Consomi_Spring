package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandProduct implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcomm;
	@Temporal(TemporalType.DATE)
	private Date DateDelivery;
	private float price;
	@ManyToMany
	private List<Product> products;
	public CommandProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommandProduct(int idcomm, Date dateDelivery, float price, List<Product> products) {
		super();
		this.idcomm = idcomm;
		DateDelivery = dateDelivery;
		this.price = price;
		this.products = products;
	}
	

}
