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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repair implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idrepair;
private float coast;
private String Description;
public Repair() {
	super();
	// TODO Auto-generated constructor stub
}
public Repair(int idrepair, float coast, String description) {
	super();
	this.idrepair = idrepair;
	this.coast = coast;
	Description = description;
}


}
