package tn.esprit.pidev.Controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Ads;
import tn.esprit.pidev.entities.AdsView;
import tn.esprit.pidev.service.AdsService;
import tn.esprit.pidev.service.AdsViewService;

@RestController
public class AdsRestController {
	
	@Autowired
	AdsService adsservice;
	
	@Autowired
	AdsViewService adsviewservice;
	
	@PostMapping("/AddAds")
	@ResponseBody
	public Ads AddAds(@RequestBody Ads a){
		adsservice.AddAd(a);
		AdsView adsview=new AdsView();
		adsview.setAds(a);
		adsviewservice.AddAdsView(adsview);
		return adsview.getAds();
	}
	@PutMapping("/ModsDate/{AdsId}")
	@ResponseBody
	public Date Mod_SDate(@PathVariable("AdsId")int AdsId,@RequestBody Date new_SDate){
		
		adsservice.Mod_SDate(AdsId, new_SDate);
		return new_SDate;
		
	}
	
	@PutMapping("/ModfDate/{AdsId}")
	@ResponseBody
	public Date Mod_FDate(@PathVariable("AdsId")int AdsId,@RequestBody Date new_FDate){
		
		adsservice.Mod_SDate(AdsId, new_FDate);
		return new_FDate;
		
	}
	
	@GetMapping("/GetAds")
	@ResponseBody
	public List<Ads> getAds(){
		List<Ads> list = adsservice.GetAllAds();
		return list;
	}
	
	
	@GetMapping("/GetAdsByFDate")
	@ResponseBody
	public List<Ads> getAdsByFDate(@RequestBody Date Fdate){
		return adsservice.GetAdsByFDate(Fdate);
	}
	
	@GetMapping("/GetAdsBySDate")
	@ResponseBody
	public List<Ads> getAdsBySDate(@RequestBody Date Sdate){
		return adsservice.GetAdsBySDate(Sdate);
	}
	
	@GetMapping("/getPrevious/{prodId}")
	@ResponseBody
	public List<AdsView> GetpreviousStat(@PathVariable("prodId")int prodId){
		return adsservice.previousStats(prodId);
	}
	
	@PutMapping("/ModTargetView/{adsId}")
	@ResponseBody
	public String ModTargetView_tot(@PathVariable("adsId")int AdsId,@RequestBody int vCount) {
		return adsservice.ModTargetView_tot(AdsId, vCount);
	}
	
	
	
	
	
	
}
	
