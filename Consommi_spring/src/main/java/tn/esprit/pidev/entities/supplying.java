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
public class supplying implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSupp;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private String Product;
	private float quantity;
	private float tot_coast;
	@Temporal(TemporalType.DATE)
	private Date d_arrivale;
	public int getIdSupp() {
		return idSupp;
	}
	public void setIdSupp(int idSupp) {
		this.idSupp = idSupp;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getTot_coast() {
		return tot_coast;
	}
	public void setTot_coast(float tot_coast) {
		this.tot_coast = tot_coast;
	}
	public Date getD_arrivale() {
		return d_arrivale;
	}
	public void setD_arrivale(Date d_arrivale) {
		this.d_arrivale = d_arrivale;
	}
	
	
	

}
