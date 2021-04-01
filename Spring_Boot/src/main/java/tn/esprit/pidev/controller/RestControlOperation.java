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

//verser
@PutMapping(value = "/verser/{idc}/{montant}")
public boolean verser(@PathVariable("idc") int idcpt,@PathVariable("montant") double montant) {
	return opserv.verser(idcpt, montant);
}

//retirer
@PutMapping(value = "/retirer/{idc}/{montant}")
public boolean retirer(@PathVariable("idc") int idcpt,@PathVariable("montant") double montant) {
	return opserv.retirer(idcpt, montant);
}

//remboursement de commande annulé
@PutMapping(value = "/virement/{idc1}/{idc2}/{montant}/{idcmd}")
public String virement(@PathVariable("idc1") int cpte1,@PathVariable("idc2")  int cpte2,@PathVariable("idcmd")int idc) {
	return opserv.virement(cpte1, cpte2, idc);
}
//verser montant au compte responsable lorsque le payement est porte a porte 
@PutMapping(value = "/payamounttoseller/{idcpt}/{idc}")
public String payamounttoselleraccount(@PathVariable("idcpt") int idcpt,@PathVariable("idc")int idc ) {
	return opserv.payamounttoselleraccount(idcpt, idc);
}
//virement lorsque le payement est bytransfer
@PutMapping(value = "/paybytransfer/{idc}/{idc1}/{idc2}")
public String paymentbytransfer(@PathVariable("idc") int idc,@PathVariable("idc1")int cpte1,@PathVariable("idc2") int cpte2) {
	return opserv.paymentbytransfer(idc, cpte1, cpte2);
}
}
