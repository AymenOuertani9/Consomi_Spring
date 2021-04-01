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


@Entity

public class Role implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idRole;
private String Description;
@Enumerated(EnumType.STRING)
private Roletype type;
@OneToMany(mappedBy = "role")
private List<User>users;
public int getIdRole() {
	return idRole;
}
public void setIdRole(int idRole) {
	this.idRole = idRole;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public Roletype getType() {
	return type;
}
public void setType(Roletype type) {
	this.type = type;
}
public List<User> getUsers() {
	return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}


}
