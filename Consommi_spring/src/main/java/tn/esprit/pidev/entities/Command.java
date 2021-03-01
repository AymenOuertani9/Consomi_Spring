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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Command implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcommand;
	private double AmountCommand;
	@Temporal(TemporalType.DATE)
	private Date DateCommand;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	@Temporal(TemporalType.DATE)
	private Date DateSend;
	private int numsend;
	private int numcommand;
	private int tva;
	@Enumerated(EnumType.STRING)
	private ModePayement payement;
	private Boolean validpayement;
	@OneToOne
	private Cart cart;
	@OneToOne
	private Transaction transaction;
	@OneToOne(mappedBy = "command")
	private Bill bill;
	@OneToOne(mappedBy = "command")
	private DeliveryNote deliverynote;

	

	

}
