package tn.esprit.pidev.Controllers;

import java.util.ArrayList;
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
import tn.esprit.pidev.service.AdsViewService;

@RestController
public class AdsViewController {
	
	@Autowired
	AdsViewService adsviewservice;
	
	@GetMapping("/getAllAdsView")
	@ResponseBody
	public List<AdsView> GetAllAdsView(){
		List<AdsView> list = adsviewservice.getAllAdsView();
		return list;
	}
	@GetMapping("/AdsViewToday")
	@ResponseBody
	public List<AdsView> AdsViewToday() {
		return adsviewservice.AdsViewToday();
	}
	
	@PutMapping("/AdsView/{adId}/{userId}")
	@ResponseBody
	public void Addview(@PathVariable("adId")int AdId,@PathVariable("userId") int userId) {
		
		adsviewservice.Addview(AdId, userId);
	}
	
	@GetMapping("/finalStats")
	@ResponseBody
	public ArrayList finalStats() {
		return adsviewservice.finalStats();
	}
	
}
