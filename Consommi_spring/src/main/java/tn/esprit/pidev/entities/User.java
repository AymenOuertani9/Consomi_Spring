package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iduser;
	private String Lastname;
	private String Firstname;
	private String Adress;
	private String Login;
	private String password;
	private int Tel;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private String picture;
	@ManyToOne
	private Role role;
	@OneToOne
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
	


}
