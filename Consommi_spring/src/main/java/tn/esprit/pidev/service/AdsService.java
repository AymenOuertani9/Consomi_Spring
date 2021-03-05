package tn.esprit.pidev.service;

import java.util.Date;
import java.util.List;

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

	@Override
	public void Mod_SDate(int AdsID, Date new_SDate) {
		// TODO Auto-generated method stub
		Ads ad=adsrepository.findById(AdsID).orElse(null);
		ad.setStartDate(new_SDate);
		
	}

	@Override
	public void Mod_FDate(int AdsId, Date new_FDate) {
		// TODO Auto-generated method stub
		Ads ad=adsrepository.findById(AdsId).orElse(null);
		ad.setStartDate(new_FDate);
		
	}

	@Override
	public List<Ads> GetAllAds() {
		// TODO Auto-generated method stub
		return (List<Ads>) adsrepository.findAll();
		
		
	}

	@Override
	public List<Ads> GetAdsByFDate(Date FDate) {
		
		return (List<Ads>) adsrepository.getAdsByFinishDate(FDate);
		}

	@Override
	public List<Ads> GetAdsBySDate(Date SDate) {
		// TODO Auto-generated method stub
		return (List<Ads>) adsrepository.getAdsByStartDate(SDate);
	}

}
