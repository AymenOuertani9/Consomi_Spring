package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryMan implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int iddeliveryman;
private String Totworkhour;
private Boolean availability;
private float Totaldelivery;
private float premium;
@OneToMany(mappedBy = "deliveryman")
private List<Delivery> deliveris;
@OneToMany(mappedBy = "deliveryman")
private List<RequestLeave>requestleave;
@OneToMany(mappedBy = "deliveryman")
private List<ExtraTime>extratimes;





}
