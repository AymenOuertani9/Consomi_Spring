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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity

public class Bill implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBill;
	private int numBill;
	
	private double totalfinal;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date datereglement;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date datebill;
	@Enumerated(EnumType.STRING)
	private TypeFacture typeofbill;
	@OneToOne(mappedBy = "bill")
	private Claim claim;
	@OneToOne
	private Command command;
	@OneToOne
	private User user;
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
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(int idBill, int numBill, float totalfinal, Date datereglement, Date datebill, TypeFacture typeofbill,
			Claim claim, Command command, User user) {
		super();
		this.idBill = idBill;
		this.numBill = numBill;
		this.totalfinal = totalfinal;
		this.datereglement = datereglement;
		this.datebill = datebill;
		this.typeofbill = typeofbill;
		this.claim = claim;
		this.command = command;
		this.user = user;
	}
	
	
}
