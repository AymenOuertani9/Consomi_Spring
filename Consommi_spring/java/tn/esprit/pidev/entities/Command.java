package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Command implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcommand;
	private double price;
	private String currency;
	private String method;
	private String intent;
	private String description;
	private double AmountCommand;
private int Reduction;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateCreation;
	@Temporal(TemporalType.DATE)

	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateSend;
	@Enumerated(EnumType.STRING)
	private  Etat etat;
	private int numcommand;
	private int tva;
	@Enumerated(EnumType.STRING)
	private ModePayement payement;
	private Boolean validpayement;

	@OneToOne

	private Cart cart;
	@OneToOne
	private Transaction transaction;
	@OneToOne(mappedBy = "command",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	private Bill bill;
	@ManyToOne
	private User user;
	@OneToOne(mappedBy = "commande",cascade = CascadeType.REMOVE)
	private Delivery delivery;
	@OneToMany(mappedBy = "comande",cascade = CascadeType.REMOVE)
	private List<Remarque>remarques;
	@OneToOne(mappedBy = "command")
	private Stock stock;

	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public String getMethod() {
		return method;
	}



	public void setMethod(String method) {
		this.method = method;
	}



	public String getIntent() {
		return intent;
	}



	public void setIntent(String intent) {
		this.intent = intent;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getReduction() {
		return Reduction;
	}



	public void setReduction(int reduction) {
		Reduction = reduction;
	}



	public int getIdcommand() {
		return idcommand;
	}

	public void setIdcommand(int idcommand) {
		this.idcommand = idcommand;
	}

	public double getAmountCommand() {
		/*if(!cart.getLignescmd().isEmpty()) {
		for(LigneComand lc:cart.getLignescmd()) {
		double totalligne=cart.getTotal()+tva+delivery.getFraislivraison();
		AmountCommand=AmountCommand+totalligne;
		}

	}*/
		return AmountCommand;
	}

	public void setAmountCommand(double amountCommand) {
		AmountCommand = amountCommand;
	}






	public Stock getStock() {
		return stock;
	}



	public void setStock(Stock stock) {
		this.stock = stock;
	}



	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateSend() {
		return dateSend;
	}

	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getNumcommand() {
		return numcommand;
	}

	public void setNumcommand(int numcommand) {
		this.numcommand = numcommand;
	}

	public int getTva() {
		return tva;
	}

	public void setTva(int tva) {
		this.tva = tva;
	}

	public ModePayement getPayement() {
		return payement;
	}

	public void setPayement(ModePayement payement) {
		this.payement = payement;
	}

	public Boolean getValidpayement() {
		return validpayement;
	}

	public void setValidpayement(Boolean validpayement) {
		this.validpayement = validpayement;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public List<Remarque> getRemarques() {
		return remarques;
	}

	public void setRemarques(List<Remarque> remarques) {
		this.remarques = remarques;
	}



	public Command(int idcommand, double amountCommand, Date dateCreation, Date dateSend, Etat etat, int numcommand,
			int tva, ModePayement payement, Boolean validpayement, Cart cart, Transaction transaction, Bill bill,
			User user, Delivery delivery, List<Remarque> remarques) {
		super();
		this.idcommand = idcommand;
		AmountCommand = amountCommand;
		this.dateCreation = dateCreation;
		this.dateSend = dateSend;
		this.etat = etat;
		this.numcommand = numcommand;
		this.tva = tva;
		this.payement = payement;
		this.validpayement = validpayement;
		this.cart = cart;
		this.transaction = transaction;
		this.bill = bill;
		this.user = user;
		this.delivery = delivery;
		this.remarques = remarques;
	}



	@Override
	public String toString() {
		return "Command [idcommand=" + idcommand + ", AmountCommand=" + AmountCommand + ", dateCreation=" + dateCreation
				+ ", dateSend=" + dateSend + ", etat=" + etat + ", numcommand=" + numcommand + ", tva=" + tva
				+ ", payement=" + payement + ", validpayement=" + validpayement + ", cart=" + cart + ", transaction="
				+ transaction + ", bill=" + bill + ", user=" + user + ", delivery=" + delivery + ", remarques="
				+ remarques + "]";
	}













}
