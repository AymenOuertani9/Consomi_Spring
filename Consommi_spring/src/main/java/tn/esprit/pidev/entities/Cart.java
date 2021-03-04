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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity

public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcart;
	@Temporal(TemporalType.DATE)
	private Date date;
	private double total;
	private int qte;
	private String currency;
	@ManyToMany
	private List<Product> products;

	@ManyToOne
	private User user;
	@OneToOne(mappedBy = "cart")
	private Command command;
	/*@OneToMany(mappedBy = "cart")
	private List<LigneComand>lignescmd;*/
	public int getIdcart() {
		return idcart;
	}
	public void setIdcart(int idcart) {
		this.idcart = idcart;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}

	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int idcart, double total, int qte, String currency,User user, Command command) {
		super();
		this.idcart = idcart;
		this.total = total;
		this.qte = qte;
		this.currency = currency;

		this.user = user;
		this.command = command;
	}
	public Cart(double total, int qte, String currency, User user, Command command) {
		super();
		this.total = total;
		this.qte = qte;
		this.currency = currency;

		this.user = user;
		this.command = command;
	}
	public Cart(int qte,User user) {
		super();
		this.qte = qte;

		this.user = user;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	


}
