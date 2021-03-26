package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@JsonDeserialize
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class UserConsomi implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iduser;
	private String Lastname;
	@Column(name="username")
	private String username;
	private String Adress;
	private String Login;
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private int nbrpoint;
	private int Tel;
	private String Email;
	private Boolean connected;


	//private String roles ;
    private boolean active = false;

	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private String picture;
	private String accBalance;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Role> role = new ArrayList<>();
//	@ManyToOne
//	private Role role;
	@OneToOne(mappedBy="user")
	private Contrat contrat;

	@OneToMany(mappedBy = "user")
	private List<Claim>claims;
	@OneToMany(mappedBy = "user")
	private List<Product>products;
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
	@OneToOne(mappedBy = "user")
	private Command command;
	@OneToOne(mappedBy = "user")
	private Bill bill;
	
	
	


	


	

	public UserConsomi() {
		super();
		// TODO Auto-generated constructor stub
	}










	










	public UserConsomi(int iduser, String username, String password, List<Role> role) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	





















	public UserConsomi(String lastname, String username, String adress, String login, String password, int nbrpoint, int tel,
			String email, boolean active, Date dateCreation, String picture,String accBalance,boolean connected ,List<Role> role,
			Contrat contrat, List<Claim> claims, List<Product> products, List<Stock> stocks, List<Donation> donation,
			List<Cart> carts, List<Participation> participations, List<Commentaire> commentaire, List<Rating> rating,
			Command command, Bill bill) {
		super();
		Lastname = lastname;
		this.username = username;
		Adress = adress;
		Login = login;
		this.password = password;
		this.nbrpoint = nbrpoint;
		Tel = tel;
		Email = email;
		//this.roles = roles;
		this.active = active;
		DateCreation = dateCreation;
		this.picture = picture;
		this.accBalance = accBalance;
		this.connected=connected;
		this.role = role;
		this.contrat = contrat;
		this.claims = claims;
		this.products = products;
		this.stocks = stocks;
		this.donation = donation;
		this.carts = carts;
		this.participations = participations;
		this.commentaire = commentaire;
		this.rating = rating;
		this.command = command;
		this.bill = bill;
	}










	










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



















	public String getUsername() {
		return username;
	}





















	public void setUsername(String username) {
		this.username = username;
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










	public String getEmail() {
		return Email;
	}










	public void setEmail(String email) {
		Email = email;
	}










//	public String getRoles() {
//		return roles;
//	}
//
//
//
//
//
//
//
//
//
//
//	public void setRoles(String roles) {
//		this.roles = roles;
//	}










	public boolean isActive() {
		return active;
	}










	public void setActive(boolean active) {
		this.active = active;
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










	public List<Role> getRole() {
		return role;
	}










	public void setRole(List<Role> role) {
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










	public List<Product> getProducts() {
		return products;
	}










	public void setProducts(List<Product> products) {
		this.products = products;
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










	public Command getCommand() {
		return command;
	}










	public void setCommand(Command command) {
		this.command = command;
	}










	public Bill getBill() {
		return bill;
	}










	public void setBill(Bill bill) {
		this.bill = bill;
	}





















	public String getAccBalance() {
		return accBalance;
	}





















	public void setAccBalance(String accBalance) {
		this.accBalance = accBalance;
	}





















	public Boolean getConnected() {
		return connected;
	}





















	public void setConnected(Boolean connected) {
		this.connected = connected;
	}








	
	

}
