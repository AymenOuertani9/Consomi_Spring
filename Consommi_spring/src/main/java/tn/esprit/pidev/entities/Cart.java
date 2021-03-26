package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcart;
	private double total;

	private String currency;
	@ManyToMany
	private List<Product> products;
	@ManyToOne
	private UserConsomi user;
	@OneToOne(mappedBy = "cart")
	private Command command;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int idcart, double total, String currency, List<Product> products, UserConsomi user, Command command) {
		super();
		this.idcart = idcart;
		this.total = total;
		this.currency = currency;
		this.products = products;
		this.user = user;
		this.command = command;
	}

	
}
