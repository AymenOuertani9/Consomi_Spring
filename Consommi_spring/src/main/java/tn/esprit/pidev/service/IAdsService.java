package tn.esprit.pidev.service;

import tn.esprit.pidev.entities.Ads;

public interface IAdsService {
	
	void AddAd(Ads ads);
	void ModAd(int AdsId,Ads ads);
	

}
