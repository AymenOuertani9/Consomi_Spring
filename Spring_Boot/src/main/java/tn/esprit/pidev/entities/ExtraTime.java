package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity

public class ExtraTime implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idextra;
private Date dateextra;
private int NbrHour;
@ManyToOne
private DeliveryMan deliveryman;


}
