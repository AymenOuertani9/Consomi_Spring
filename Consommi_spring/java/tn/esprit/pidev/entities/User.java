package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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


public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iduser;
	private String Lastname;
	private String Firstname;
	private String Adress;
	private String Login;
	private String password;
	private int nbrpoint;
	private int Tel;
	@OneToMany(mappedBy = "user")
	private List<Remarque>remarques;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private String picture;
	@OneToOne(mappedBy = "user")
	private LigneComand lc;
	@ManyToOne
	private Role role;
	@OneToOne
	private Contrat contrat;

	@OneToMany(mappedBy = "user")
	private List<Claim>claims;
	
	@OneToMany(mappedBy = "user")
	private List<Stock> stocks;
	@OneToMany(mappedBy="user")
	private List<Donation> donation;
	@OneToMany(mappedBy="user")
	private List<Cart> carts;
	@OneToMany(cascade= CascadeType.ALL, mappedBy= "user")
	private List<Participation> participations;
	@OneToMany(mappedBy = "user")
	private List<Commentaire> commentaire;
	@OneToMany(mappedBy = "user")
	private List <Rating> rating;
	@OneToMany(mappedBy = "user")
	private List<Command> command;
	@OneToOne(mappedBy = "user")
	private Bill bill;
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private List<Compte> comptes;
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNbrpoint() {
		return nbrpoint;
	}
	public void setNbrpoint(int nbrpoint) {
		this.nbrpoint = nbrpoint;
	}
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	public List<Donation> getDonation() {
		return donation;
	}
	public void setDonation(List<Donation> donation) {
		this.donation = donation;
	}
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public List<Participation> getParticipations() {
		return participations;
	}
	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}
	public List<Commentaire> getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(List<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}
	public List<Rating> getRating() {
		return rating;
	}
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
	
	public List<Command> getCommand() {
		return command;
	}
	public void setCommand(List<Command> command) {
		this.command = command;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public User(int iduser, String lastname, String firstname, String adress, String login, String password,
			int nbrpoint, int tel, Date dateCreation, String picture, Role role, Contrat contrat, List<Claim> claims,
			List<Stock> stocks, List<Donation> donation, List<Cart> carts, List<Participation> participations,
			List<Commentaire> commentaire, List<Rating> rating,Bill bill) {
		super();
		this.iduser = iduser;
		Lastname = lastname;
		Firstname = firstname;
		Adress = adress;
		Login = login;
		this.password = password;
		this.nbrpoint = nbrpoint;
		Tel = tel;
		DateCreation = dateCreation;
		this.picture = picture;
		this.role = role;
		this.contrat = contrat;
		this.claims = claims;
		this.stocks = stocks;
		this.donation = donation;
		this.carts = carts;
		this.participations = participations;
		this.commentaire = commentaire;
		this.rating = rating;
		
		this.bill = bill;
	}
	public User(String lastname, String firstname, String adress, String login, String password, int nbrpoint, int tel,
			Date dateCreation, String picture, Role role, Contrat contrat, List<Claim> claims, List<Stock> stocks,
			List<Donation> donation, List<Cart> carts, List<Participation> participations,
			List<Commentaire> commentaire, List<Rating> rating, Bill bill) {
		super();
		Lastname = lastname;
		Firstname = firstname;
		Adress = adress;
		Login = login;
		this.password = password;
		this.nbrpoint = nbrpoint;
		Tel = tel;
		DateCreation = dateCreation;
		this.picture = picture;
		this.role = role;
		this.contrat = contrat;
		this.claims = claims;
		this.stocks = stocks;
		this.donation = donation;
		this.carts = carts;
		this.participations = participations;
		this.commentaire = commentaire;
		this.rating = rating;
		
		this.bill = bill;
	}
	public User() {
		super();
	}
	public LigneComand getLc() {
		return lc;
	}
	public void setLc(LigneComand lc) {
		this.lc = lc;
	}
	public List<Remarque> getRemarques() {
		return remarques;
	}
	public void setRemarques(List<Remarque> remarques) {
		this.remarques = remarques;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

}
 