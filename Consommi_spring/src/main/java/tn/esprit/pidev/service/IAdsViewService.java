package tn.esprit.pidev.service;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.pidev.entities.AdsView;
import tn.esprit.pidev.entities.User;

public interface IAdsViewService {

	int AddAdsView(AdsView adsview);
	List<AdsView> getAllAdsView();
	List<AdsView> AdsViewToday();
	AdsView Addview(int AdId, int userId);
	ArrayList finalStats();
	void AffectAdsviewtoAds(int AdId,AdsView adsview);
}
