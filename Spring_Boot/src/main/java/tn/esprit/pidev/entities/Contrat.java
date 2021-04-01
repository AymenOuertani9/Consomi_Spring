package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity

public class Contrat implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcontrat;
	private float salary;
	private Date DateDebut;
	private Date DateFin;
	private ContratType typecontrat;
	@OneToOne(mappedBy = "contrat")
	private User user;
	
}
