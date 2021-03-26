package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contrat implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcontrat;
	private float salary;
	private Date DateDebut;
	private Date DateFin;
	//@Enumerated(EnumType.STRING)
	private ContratType typecontrat;
	@OneToOne
//	(mappedBy = "contrat" ,cascade ={CascadeType.PERSIST ,CascadeType.REMOVE},
//			fetch=FetchType.LAZY)
	private UserConsomi user;
	
	
	
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Contrat(int idcontrat, float salary, Date dateDebut, Date dateFin, ContratType typecontrat,
			UserConsomi user) {
		super();
		this.idcontrat = idcontrat;
		this.salary = salary;
		DateDebut = dateDebut;
		DateFin = dateFin;
		this.typecontrat = typecontrat;
		this.user = user;
	}



	public int getIdcontrat() {
		return idcontrat;
	}



	public void setIdcontrat(int idcontrat) {
		this.idcontrat = idcontrat;
	}



	public float getSalary() {
		return salary;
	}



	public void setSalary(float salary) {
		this.salary = salary;
	}



	public Date getDateDebut() {
		return DateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}



	public Date getDateFin() {
		return DateFin;
	}



	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}



	public ContratType getTypecontrat() {
		return typecontrat;
	}



	public void setTypecontrat(ContratType typecontrat) {
		this.typecontrat = typecontrat;
	}



	public UserConsomi getUser() {
		return user;
	}



	public void setUser(UserConsomi user) {
		this.user = user;
	}
	

	
}
