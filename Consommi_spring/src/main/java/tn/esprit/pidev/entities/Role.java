package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Role implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idRole;
private String role;
@Enumerated(EnumType.STRING)
private Roletype type;
//@OneToMany(mappedBy = "role")
//private List<User>users;

public Role() {
	super();
	// TODO Auto-generated constructor stub
}

public Role( String role) {
	super();
	this.role = role;
}







public int getIdRole() {
	return idRole;
}
public void setIdRole(int idRole) {
	this.idRole = idRole;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Roletype getType() {
	return type;
}
public void setType(Roletype type) {
	this.type = type;
}


}
