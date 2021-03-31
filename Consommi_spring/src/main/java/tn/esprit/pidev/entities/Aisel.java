package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aisel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAisel;
	private String name;
	private String type;
	private int Capacitymax;
	@OneToMany(mappedBy = "aisel")
	private List<Product> products;
	
	public int getIdAisel() {
		return idAisel;
	}
	public void setIdAisel(int idAisel) {
		this.idAisel = idAisel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacitymax() {
		return Capacitymax;
	}
	public void setCapacitymax(int capacitymax) {
		Capacitymax = capacitymax;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
}
