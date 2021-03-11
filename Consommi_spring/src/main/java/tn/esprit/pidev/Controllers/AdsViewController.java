package tn.esprit.pidev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.AdsView;
import tn.esprit.pidev.service.AdsViewService;

@RestController
public class AdsViewController {
	
	@Autowired
	AdsViewService adsviewservice;
	
	
	@PostMapping("/AddAdsView")
	@ResponseBody
	public void AddAdsView(@RequestBody AdsView adsview){
		
		adsviewservice.AddAdsView(adsview);
	}
	
	@GetMapping("/getAllAdsView")
	@ResponseBody
	public void GetAllAdsView(){
		
		adsviewservice.getAllAdsView();
	}

}
