package tn.esprit.pidev.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProgrammeFidelité {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfidilite;
	@Enumerated(EnumType.STRING)
	private Etatfidelite etat;
	@Enumerated(EnumType.STRING)
	private Typefidelite type;
	@OneToOne
	private Command command;
	public int getIdfidilite() {
		return idfidilite;
	}
	public void setIdfidilite(int idfidilite) {
		this.idfidilite = idfidilite;
	}
	public Etatfidelite getEtat() {
		return etat;
	}
	public void setEtat(Etatfidelite etat) {
		this.etat = etat;
	}
	public Typefidelite getType() {
		return type;
	}
	public void setType(Typefidelite type) {
		this.type = type;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	
}
