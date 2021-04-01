package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity

public class Bill implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBill;
	private int numBill;
	@Temporal(TemporalType.DATE)
	private Date DateBill;
	private float totalfinal;
	private Date datereglement;
	private TypeFacture tupefac;
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
	public Date getDateBill() {
		return DateBill;
	}
	public void setDateBill(Date dateBill) {
		DateBill = dateBill;
	}
	public float getTotalfinal() {
		return totalfinal;
	}
	public void setTotalfinal(float totalfinal) {
		this.totalfinal = totalfinal;
	}
	public Date getDatereglement() {
		return datereglement;
	}
	public void setDatereglement(Date datereglement) {
		this.datereglement = datereglement;
	}
	public TypeFacture getTupefac() {
		return tupefac;
	}
	public void setTupefac(TypeFacture tupefac) {
		this.tupefac = tupefac;
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
	public Bill(int idBill, int numBill, Date dateBill, float totalfinal, Date datereglement, TypeFacture tupefac,
			Claim claim, Command command, User user) {
		super();
		this.idBill = idBill;
		this.numBill = numBill;
		DateBill = dateBill;
		this.totalfinal = totalfinal;
		this.datereglement = datereglement;
		this.tupefac = tupefac;
		this.claim = claim;
		this.command = command;
		this.user = user;
	}

}
