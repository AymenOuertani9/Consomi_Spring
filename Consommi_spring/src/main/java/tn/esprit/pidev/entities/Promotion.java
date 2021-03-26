package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpromotion;
	@Temporal(TemporalType.DATE)
	private Date Startingdate;
	@Temporal(TemporalType.DATE)
	private Date EndingDate;
	private String libelle;
	private String Description;
	private long percentage;
	@ManyToOne
	private Product product;
	
	
	
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Promotion(int idpromotion, Date startingdate, Date endingDate, String libelle, String description,
			long percentage, Product product) {
		super();
		this.idpromotion = idpromotion;
		Startingdate = startingdate;
		EndingDate = endingDate;
		this.libelle = libelle;
		Description = description;
		this.percentage = percentage;
		this.product = product;
	}
	
	
}
