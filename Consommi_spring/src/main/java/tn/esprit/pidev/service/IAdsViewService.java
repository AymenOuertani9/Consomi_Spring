package tn.esprit.pidev.service;

import java.util.List;

import tn.esprit.pidev.entities.AdsView;

public interface IAdsViewService {

	int AddAdsView(AdsView adsview);
	List<AdsView> getAllAdsView();
	
}
