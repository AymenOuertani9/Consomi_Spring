package tn.esprit.pidev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	
	

}
