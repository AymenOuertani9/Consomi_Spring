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
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Currency;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Valid
public class Command implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcommand;

	@Positive(message = "price must be positif")
	private double price;
	private int paymentterm;
	//@Currency(value = { "TND" ,"USD","EUR","DZD","SAR"})
	private String currency;

	private String method;
	private String intent;

	@Size(min=4,message = " Description should have atleast 4 characters")
	private String description;
	//private double AmountCommand;
	private int reduction;
	//@FutureOrPresent
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateCreation;
	//@FutureOrPresent
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateSend;
	@Enumerated(EnumType.STRING)
	private  Etat etat;
	@Positive
	private int numcommand;
	@PositiveOrZero
	private int tva;
	@Enumerated(EnumType.STRING)
	private ModePayement payement;
	private Boolean validpayement;

	@OneToOne

	private Cart cart;
	@OneToOne
	private ExchangeValue transaction;
	@OneToOne(mappedBy = "command")
	private ProgrammeFidelité programmefidel;
	
	@OneToOne
	private Delivery delivery;
	@OneToMany(mappedBy = "comande",cascade = CascadeType.REMOVE)
	private List<Remarque>remarques;
	@OneToOne(mappedBy = "command")
	private Stock stock;

	public Command() {
		super();
		
	}



	public ProgrammeFidelité getProgrammefidel() {
		return programmefidel;
	}



	public void setProgrammefidel(ProgrammeFidelité programmefidel) {
		this.programmefidel = programmefidel;
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
		return reduction;
	}



	public void setReduction(int reduction) {
		this.reduction = reduction;
	}



	public int getIdcommand() {
		return idcommand;
	}

	public void setIdcommand(int idcommand) {
		this.idcommand = idcommand;
	}

	/*public double getAmountCommand() {
		/*if(!cart.getLignescmd().isEmpty()) {
		for(LigneComand lc:cart.getLignescmd()) {
		double totalligne=cart.getTotal()+tva+delivery.getFraislivraison();
		AmountCommand=AmountCommand+totalligne;
		}

	}*/
	/*return AmountCommand;
	}

	public void setAmountCommand(double amountCommand) {
		AmountCommand = amountCommand;
	}



	 */


	public int getPaymentterm() {
		return paymentterm;
	}



	public void setPaymentterm(int paymentterm) {
		this.paymentterm = paymentterm;
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

	public ExchangeValue getTransaction() {
		return transaction;
	}

	public void setTransaction(ExchangeValue transaction) {
		this.transaction = transaction;
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



	public Command(int idcommand, double price, String currency, String method, String intent, String description,
			int reduction, Date dateCreation, Date dateSend, Etat etat, int numcommand, int tva, ModePayement payement,
			Boolean validpayement, Cart cart, ExchangeValue transaction, Delivery delivery,
			List<Remarque> remarques, Stock stock) {
		super();
		this.idcommand = idcommand;
		this.price = price;
		this.currency = currency;
		this.method = method;
		this.intent = intent;
		this.description = description;
		
		this.dateCreation = dateCreation;
		this.dateSend = dateSend;
		this.etat = etat;
		this.numcommand = numcommand;
		this.tva = tva;
		this.payement = payement;
		this.validpayement = validpayement;
		this.cart = cart;
		this.transaction = transaction;
		
		
		this.delivery = delivery;
		this.remarques = remarques;
		this.stock = stock;
	}



	@Override
	public String toString() {
		return "Command [idcommand=" + idcommand + ", price=" + price + ", currency=" + currency + ", method=" + method
				+ ", intent=" + intent + ", description=" + description + ", dateCreation="
				+ dateCreation + ", dateSend=" + dateSend + ", etat=" + etat + ", numcommand=" + numcommand + ", tva="
				+ tva + ", payement=" + payement + ", validpayement=" + validpayement + ", cart=" + cart
				+ ", transaction=" + transaction + ",  delivery=" + delivery
				+ ", remarques=" + remarques + ", stock=" + stock + "]";
	}













}
