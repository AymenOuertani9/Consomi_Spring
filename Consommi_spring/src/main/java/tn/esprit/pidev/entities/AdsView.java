package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdsView implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdsView;
	private float Total_Num;
	private float Total_man;
	private float Total_Woman;
	@ElementCollection
	private List<Integer> age;
	@OneToOne
	private Ads ads;
	
	

	public float getTotal_Num() {
		return Total_Num;
	}

	public void setTotal_Num(float total_Num) {
		Total_Num = total_Num;
	}

	public float getTotal_man() {
		return Total_man;
	}

	public void setTotal_man(float total_man) {
		Total_man = total_man;
	}

	public float getTotal_Woman() {
		return Total_Woman;
	}

	public void setTotal_Woman(float total_Woman) {
		Total_Woman = total_Woman;
	}

	public List<Integer> getAge() {
		return age;
	}

	public void setAge(List<Integer> age) {
		this.age = age;
	}

	public Ads getAds() {
		return ads;
	}

	public void setAds(Ads ads) {
		ads = ads;
	}

	public int getIdAdsView() {
		return idAdsView;
	}

	public void setIdAdsView(int idAdsView) {
		this.idAdsView = idAdsView;
	}
	
	

	
}
