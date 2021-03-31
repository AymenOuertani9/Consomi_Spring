package tn.esprit.pidev.service;

import java.util.Date;
import java.util.List;

import tn.esprit.pidev.entities.Ads;

public interface IAdsService {
	
	void AddAd(Ads ads);
	void ModAd(int AdsId,Ads ads);
	void Mod_SDate(int AdsID,Date new_SDate);
	void Mod_FDate(int AdsId,Date new_FDate);
	List<Ads> GetAllAds();
	List<Ads> GetAdsByFDate(Date FDate);
	List<Ads> GetAdsBySDate(Date SDate);
	void previousStats(int prodId);
	void ModTargetView_tot(int AdsId,int vCount);

}
