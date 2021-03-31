package tn.esprit.pidev.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@PostMapping("/AddAdsView")
	@ResponseBody
	public void AddAdsView(@RequestBody AdsView adsview){
		
		adsviewservice.AddAdsView(adsview);
	}
	
	@GetMapping("/getAllAdsView")
	@ResponseBody
	public List<AdsView> GetAllAdsView(){
		List<AdsView> list = adsviewservice.getAllAdsView();
		return list;
	}

	
	
}
