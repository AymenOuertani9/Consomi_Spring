package tn.esprit.pidev.entities;

import java.io.Serializable;
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
public class Radius implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRadius;
	private String name;
	private String type;
	private int Capacitymax;
	@OneToMany(mappedBy = "radius")
	private List<Product>products;
	public Radius() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Radius(int idRadius, String name, String type, int capacitymax, List<Product> products) {
		super();
		this.idRadius = idRadius;
		this.name = name;
		this.type = type;
		Capacitymax = capacitymax;
		this.products = products;
	}
	
	

}
