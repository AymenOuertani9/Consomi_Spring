package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.AdsView;
import tn.esprit.pidev.repository.IAdsViewRepository;

@Service
public class AdsViewService implements IAdsViewService {
	
	@Autowired
	IAdsViewRepository adsviewrepository;

	@Override
	public int AddAdsView(AdsView adsview) {
		// TODO Auto-generated method stub
		adsviewrepository.save(adsview);
		return adsview.getIdAds();
	}

	@Override
	public List<AdsView> getAllAdsView() {
		// TODO Auto-generated method stub
		return (List<AdsView>)adsviewrepository.findAll();
	}
	

}
