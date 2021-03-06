package tn.esprit.pidev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Ads;
import tn.esprit.pidev.entities.AdsView;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.repository.IAdsRepository;
import tn.esprit.pidev.repository.IAdsViewRepository;
import tn.esprit.pidev.repository.IProductRepository;

@Service
public class AdsService implements IAdsService {
	
	@Autowired
	IAdsRepository adsrepository;
	@Autowired
	IProductRepository productrepository;
	@Autowired
	IAdsViewRepository adsviewrepository;

	@Override
	public void AddAd(Ads ads) {
		// TODO Auto-generated method stub
		adsrepository.save(ads);
		
	}
	@Override
	public void Mod_SDate(int AdsID, Date new_SDate) {
		// TODO Auto-generated method stub
		Ads ad=adsrepository.findById(AdsID).orElse(null);
		ad.setStartDate(new_SDate);
		adsrepository.save(ad);
		
	}

	@Override
	public void Mod_FDate(int AdsId, Date new_FDate) {
		// TODO Auto-generated method stub
		Ads ad=adsrepository.findById(AdsId).orElse(null);
		ad.setStartDate(new_FDate);
		adsrepository.save(ad);
		
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

	@Override
	public List<AdsView> previousStats(int prodId) {
		List list=new ArrayList();
		Product prod=productrepository.findById(prodId).orElse(null);
		List<Ads> ads=adsrepository.getAdsByproduct(prod);
		
		for(Ads ad : ads){
			adsviewrepository.getAdsViewByAds(ad);
			list.add(adsviewrepository.getAdsViewByAds(ad));
		}

		return list;
			
	}

	@Override
	public String ModTargetView_tot(int AdsId, int vCount) {
		Ads ad=adsrepository.findById(AdsId).orElse(null);
		ad.setTargetView_tot(vCount);
		adsrepository.save(ad);
		return "Success";
		
	}

	
	
		
		
}
	
	
		
		
		

