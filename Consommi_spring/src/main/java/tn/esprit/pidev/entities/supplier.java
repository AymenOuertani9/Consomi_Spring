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
public class supplier implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSupplier;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private String Name;
	private String Product;
	private float coast;
	public supplier(int idSupplier, Date dateCreation, String name, String product, float coast) {
		super();
		this.idSupplier = idSupplier;
		DateCreation = dateCreation;
		Name = name;
		Product = product;
		this.coast = coast;
	}
	public int getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public float getCoast() {
		return coast;
	}
	public void setCoast(float coast) {
		this.coast = coast;
	}
	
	

}
