package tn.esprit.pidev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.service.IOperationService;

@RestController
public class RestControlOperation {
@Autowired
IOperationService opserv;

//URL : http://localhost:8081/SpringMVC/servlet/verser/{idc}/{montant}
@PutMapping(value = "/verser/{idc}/{montant}")
public boolean verser(@PathVariable("idc") int idcpt,@PathVariable("montant") double montant) {
	return opserv.verser(idcpt, montant);
}

//URL : http://localhost:8081/SpringMVC/servlet/retirer/{idc}/{montant}
@PutMapping(value = "/retirer/{idc}/{montant}")
public boolean retirer(@PathVariable("idc") int idcpt,@PathVariable("montant") double montant) {
	return opserv.retirer(idcpt, montant);
}

//URL : http://localhost:8081/SpringMVC/servlet/virement/{idc1}/{idc2}/{montant}/{idcmd}
@PutMapping(value = "/virement/{idc1}/{idc2}/{montant}/{idcmd}")
public boolean virement(@PathVariable("idc1") int cpte1,@PathVariable("idc2")  int cpte2,@PathVariable("montant")  double montant,@PathVariable("idcmd")int idc) {
	return opserv.virement(cpte1, cpte2, montant, idc);
}
}
