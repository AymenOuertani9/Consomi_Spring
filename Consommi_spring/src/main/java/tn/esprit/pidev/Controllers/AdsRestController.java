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
import tn.esprit.pidev.service.AdsService;

@RestController
public class AdsRestController {
	
	@Autowired
	AdsService adsservice;
	
	@PostMapping("/AddAds")
	@ResponseBody
	public Ads AddAds(@RequestBody Ads a){
		adsservice.AddAd(a);
		return a;
	}
	
	@PutMapping("/ModAds/{AdsId}/{Ads}")
	@ResponseBody
	public Ads ModAds(@PathVariable("AdsId")int AdsId,@PathVariable("ads") Ads ads){
		
		adsservice.ModAd(AdsId, ads);
		return ads;
		
	}
	
	@PutMapping("/ModsDate/{AdsId}/{new_SDate}")
	@ResponseBody
	public Date Mod_SDate(@PathVariable("AdsId")int AdsId,@PathVariable("new_SDate") Date new_SDate){
		
		adsservice.Mod_SDate(AdsId, new_SDate);
		return new_SDate;
		
	}
	
	@PutMapping("/ModfDate/{AdsId}/{new_FDate}")
	@ResponseBody
	public Date Mod_FDate(@PathVariable("AdsId")int AdsId,@PathVariable("new_FDate") Date new_FDate){
		
		adsservice.Mod_SDate(AdsId, new_FDate);
		return new_FDate;
		
	}
	
	@GetMapping("/GetAds")
	@ResponseBody
	public List<Ads> getAds(){
		List<Ads> list = adsservice.GetAllAds();
		return list;
	}
	
	
	@GetMapping("/GetAds/{FDate}")
	@ResponseBody
	public void getAdsByFDate(@PathVariable("Fdate") Date Fdate){
		adsservice.GetAdsByFDate(Fdate);
	}
	
	@GetMapping("/GetAds/{SDate}")
	@ResponseBody
	public void getAdsBySDate(@PathVariable("Sdate") Date Sdate){
		adsservice.GetAdsBySDate(Sdate);
	}
	
	@GetMapping("/getPrevious/{prodId}")
	@ResponseBody
	public void GetpreviousStat(@PathVariable("prodId")int prodId){
		adsservice.previousStats(prodId);
	}
	
	
	
	
	
	
}
	
