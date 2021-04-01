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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.CreditCardNumber;

@Entity
public class Compte implements Serializable{
	@Id // pas de generated value car C'est Un string
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcmpt;
	@CreditCardNumber(ignoreNonDigitCharacters = true,message = "CreditCardNumber is invalid")
	private String codeCompte;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Positive
	private double solde;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "compte" )
	private List <Operation> operations;
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getIdcmpt() {
		return idcmpt;
	}
	public void setIdcmpt(int idcmpt) {
		this.idcmpt = idcmpt;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	

	public Compte(String codeCompte, Date dateCreation, double solde, User user, List<Operation> operations) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.user = user;
		this.operations = operations;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
