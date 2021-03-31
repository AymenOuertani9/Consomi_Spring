package tn.esprit.pidev.service;

import java.util.List;

import tn.esprit.pidev.entities.AdsView;
import tn.esprit.pidev.entities.User;

public interface IAdsViewService {

	int AddAdsView(AdsView adsview);
	List<AdsView> getAllAdsView();
	void AdsViewToday();
	void Addview(int AdId, int userId);
	void finalStats(int AdsId);
	
}
