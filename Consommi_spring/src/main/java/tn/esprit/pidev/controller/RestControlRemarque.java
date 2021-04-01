package tn.esprit.pidev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Remarque;
import tn.esprit.pidev.service.IRemarqueService;

@RestController
public class RestControlRemarque {
	@Autowired
	IRemarqueService remserv;
	
	//URL : http://localhost:8081/SpringMVC/servlet/getRemarqueByIduser/{iduser}
	@GetMapping(value = "/getRemarqueByIduser/{iduser}")
	public List<Remarque> getRemarqueByIduser(@PathVariable("iduser")int iduser) {
		return remserv.getRemarqueByIduser(iduser); 
	}
	//URL : http://localhost:8081/SpringMVC/servlet/getRemarqueById/{remarqId}
	@GetMapping(value = "/getRemarqueById/{remarqId}")
	public Remarque getRemarqueById(@PathVariable("remarqId") int remarqId) {
		return remserv.getRemarqueById(remarqId);
	}

	//URL : http://localhost:8081/SpringMVC/servlet/getAllRemarques
	@GetMapping(value = "/getAllRemarques")
	public List<Remarque> getAllRemarques() {
		return remserv.getAllRemarques();
	}
	
	//URL : http://localhost:8081/SpringMVC/servlet/ AjouterRemarque
		@PostMapping(value = "/ AjouterRemarque")
	public Remarque AjouterRemarque(@RequestBody Remarque remarq) {
		return remserv.AjouterRemarque(remarq);
	}
		
		

		//URL : http://localhost:8081/SpringMVC/servlet/ deleteRemarqueById/{remarqueId}
			@DeleteMapping(value = "/ deleteRemarqueById/{remarqueId}")
		public void deleteRemarqueById(int remarqueId) {
				remserv.deleteRemarqueById(remarqueId);
			}
			//URL : http://localhost:8081/SpringMVC/servlet/ addOrUpdateRemarque
			@PostMapping(value = "/ addOrUpdateRemarque")
			public int addOrUpdateRemarque(@RequestBody Remarque remarque) {
				return remserv.addOrUpdateRemarque(remarque);
			}
			
			//URL : http://localhost:8081/SpringMVC/servlet/ajouteretaffecterRemarqueACommand/{idc}
			@PostMapping(value = "/ ajouteretaffecterRemarqueACommand/{idc}")
			public void ajouteretaffecterRemarqueACommand(@RequestBody Remarque remarque,@PathVariable("idc") int cmdId) {
				remserv.ajouteretaffecterRemarqueACommand(remarque, cmdId);
			}
}
