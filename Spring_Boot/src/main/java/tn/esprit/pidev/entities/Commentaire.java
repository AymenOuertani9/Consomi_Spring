package tn.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity

public class Commentaire implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idcomment;
private String description;
@ManyToOne
private Publication publication;
@ManyToOne
private User user;
}
