package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	@Transient
	private double AmountCommand;
	
	@Temporal(TemporalType.DATE)

@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date DateCreation;
	@Temporal(TemporalType.DATE)

@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date DateSend;
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
	@OneToOne(mappedBy = "command")
	private Bill bill;
	@ManyToOne
	private User user;
@OneToOne(mappedBy = "commande")
	private Delivery delivery;
@OneToMany(mappedBy = "comande")
private List<Remarque>remarques;
public Command(double amountCommand, Date dateCreation, Date dateSend,  int numcommand,
		int tva, ModePayement payement) {
	super();
	AmountCommand = amountCommand;
	
	DateCreation = dateCreation;
	DateSend = dateSend;
	
	this.numcommand = numcommand;
	this.tva = tva;
	this.payement = payement;
}

public Command() {
	super();
	// TODO Auto-generated constructor stub
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

public Date getDateCreation() {
	return DateCreation;
}

public void setDateCreation(Date dateCreation) {
	DateCreation = dateCreation;
}

public Date getDateSend() {
	return DateSend;
}

public void setDateSend(Date dateSend) {
	DateSend = dateSend;
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

	

}
