package tn.esprit.pidev.service;

import java.util.Date;
import java.util.List;

import tn.esprit.pidev.entities.Ads;
import tn.esprit.pidev.entities.AdsView;

public interface IAdsService {
	
	void AddAd(Ads ads);
	void Mod_SDate(int AdsID,Date new_SDate);
	void Mod_FDate(int AdsId,Date new_FDate);
	List<Ads> GetAllAds();
	List<Ads> GetAdsByFDate(Date FDate);
	List<Ads> GetAdsBySDate(Date SDate);
	List<AdsView> previousStats(int prodId);
	String ModTargetView_tot(int AdsId,int vCount);

}
