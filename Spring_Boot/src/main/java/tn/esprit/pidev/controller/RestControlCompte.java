package tn.esprit.pidev.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Compte;
import tn.esprit.pidev.service.IcompteService;
@ControllerAdvice
@RestController
public class RestControlCompte {
@Autowired
IcompteService comserv;
@GetMapping(value = "/getcomptebyuser/{iduser}")
public List<Compte> getCompteByIduser(@PathVariable("iduser") int iduser) 
{
	return comserv.getCompteByIduser(iduser);
	}

@GetMapping(value = "/getcomptebyid/{idc}")
public Compte getCompteById(@PathVariable("idc") int idc) {
	return comserv.getCompteById(idc);
}
@PostMapping(value = "/ajoutercompte")
public Compte AjouterCompte(@Valid @RequestBody Compte c) {
	return comserv.AjouterCompte(c);
}
@DeleteMapping(value = "deletecompte/{idc}")
public void deleteCompteById(@PathVariable("idc") int idc) {
	comserv.deleteCompteById(idc);
}
@PostMapping(value="addorupdate")
public int addOrUpdateCompte(@RequestBody Compte c) {
	return comserv.addOrUpdateCompte(c);
}

@PostMapping(value="ajouteretaffectercompteauser/{iduser}")
public void ajouteretaffecterCompteAUser(@Valid @RequestBody Compte c,@PathVariable("iduser") int idu) {
	 comserv.ajouteretaffecterCompteAUser(c, idu);
}
}
