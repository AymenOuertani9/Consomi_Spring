package tn.esprit.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Ads;
import tn.esprit.pidev.repository.IAdsRepository;

@Service
public class AdsService implements IAdsService {
	
	@Autowired
	IAdsRepository adsrepository;

	@Override
	public void AddAd(Ads ads) {
		// TODO Auto-generated method stub
		adsrepository.save(ads);
		
	}

	@Override
	public void ModAd(int AdsId, Ads ads) {
		// TODO Auto-generated method stub
		Ads ad=adsrepository.findById(AdsId).orElse(null);
	}

}
