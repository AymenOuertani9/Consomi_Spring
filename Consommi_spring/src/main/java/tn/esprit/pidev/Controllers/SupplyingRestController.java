package tn.esprit.pidev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.service.SupplyingService;

@RestController
public class SupplyingRestController {
	
	@Autowired
	SupplyingService supplyingservice;
	
	

}
