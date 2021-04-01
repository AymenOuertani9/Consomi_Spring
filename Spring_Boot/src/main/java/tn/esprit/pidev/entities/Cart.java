package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Currency;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"idcart"})})
public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idcart;
	@PositiveOrZero
	private double subtotal;
	//dzd:dolar algerien
	//riyalsaoudi:SAR
	//@Currency(value = { "TND" })
	private String currency;
	@Enumerated(EnumType.STRING)
	private EtatCart etatcart;
	@ManyToOne
	private User user;
	@OneToOne(mappedBy = "cart",cascade = {CascadeType.REMOVE , CascadeType.PERSIST})
	private Command command;
	@OneToMany(mappedBy = "cart",cascade = {CascadeType.REMOVE , CascadeType.PERSIST})
	private List<LigneComand>lignescmd;
	
	public EtatCart getEtatcart() {
		return etatcart;
	}
	public void setEtatcart(EtatCart etatcart) {
		this.etatcart = etatcart;
	}
	public int getIdcart() {
		return idcart;
	}
	public void setIdcart(int idcart) {
		this.idcart = idcart;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
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

	

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int idcart, double subtotal, String currency,User user, Command command) {
		super();
		this.idcart = idcart;
		this.subtotal = subtotal;
		
		this.currency = currency;

		this.user = user;
		this.command = command;
	}
	public Cart(double subtotal, String currency, User user, Command command) {
		super();
		this.subtotal = subtotal;
		
		this.currency = currency;

		this.user = user;
		this.command = command;
	}
	public List<LigneComand> getLignescmd() {
		return lignescmd;
	}
	public void setLignescmd(List<LigneComand> lignescmd) {
		this.lignescmd = lignescmd;
	}
	
	
	}	
	



