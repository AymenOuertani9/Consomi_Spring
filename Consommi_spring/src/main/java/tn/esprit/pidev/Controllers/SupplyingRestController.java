package tn.esprit.pidev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.supplying;
import tn.esprit.pidev.service.SupplyingService;

@RestController
public class SupplyingRestController {
	
	@Autowired
	SupplyingService supplyingservice;
	
	@PostMapping("/AddSupplying")
	@ResponseBody
	public void AddSupplying(@RequestBody supplying supplyin){
		
		supplyingservice.AddSupplying(supplyin);
	}

}
