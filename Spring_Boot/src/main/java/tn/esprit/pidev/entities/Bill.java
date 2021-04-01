package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;


@Entity

public class Bill implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBill;
	@Positive
	private int numBill;
	@Positive
	private double totalfinal;
	//@FutureOrPresent
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date datereglement;
	//@FutureOrPresent
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date datebill;
	@Enumerated(EnumType.STRING)
	private TypeFacture typeofbill;
	@OneToOne(mappedBy = "bill")
	private Claim claim;
	@OneToOne
	private Delivery delivery;
	
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public int getNumBill() {
		return numBill;
	}
	public void setNumBill(int numBill) {
		this.numBill = numBill;
	}
	
	
	public Date getDatebill() {
		return datebill;
	}
	public void setDatebill(Date datebill) {
		this.datebill = datebill;
	}
	public double getTotalfinal() {
		return totalfinal;
	}
	public void setTotalfinal(double totalfinal) {
		this.totalfinal = totalfinal;
	}
	public Date getDatereglement() {
		return datereglement;
	}
	public void setDatereglement(Date datereglement) {
		this.datereglement = datereglement;
	}
	
	public TypeFacture getTypeofbill() {
		return typeofbill;
	}
	public void setTypeofbill(TypeFacture typeofbill) {
		this.typeofbill = typeofbill;
	}
	public Claim getClaim() {
		return claim;
	}
	public void setClaim(Claim claim) {
		this.claim = claim;
	}
	
	
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(int idBill, int numBill, float totalfinal, Date datereglement, Date datebill, TypeFacture typeofbill,
			Claim claim) {
		super();
		this.idBill = idBill;
		this.numBill = numBill;
		this.totalfinal = totalfinal;
		this.datereglement = datereglement;
		this.datebill = datebill;
		this.typeofbill = typeofbill;
		this.claim = claim;
		
		
	}
	
	
}
