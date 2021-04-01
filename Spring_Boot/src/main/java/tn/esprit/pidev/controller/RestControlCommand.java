package tn.esprit.pidev.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.ModePayement;
import tn.esprit.pidev.entities.Remarque;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.ICommandRepository;
import tn.esprit.pidev.service.ICommandeService;
import tn.esprit.pidev.service.IRemarqueService;

@RestController
public class RestControlCommand {
@Autowired
ICommandeService comserv;
// get all orders 

@GetMapping(value = "/getorders")
public List<Command> getCommandes(){
	return comserv.listCommand();
}


//get order by id

@GetMapping(value = "/getorder/{idc}")
public Command getCommande(@PathVariable ("idc")int idcommand) {
	return comserv.getCommande(idcommand);
}

//get Max Num order
@GetMapping(value = "/getmaxnumorder")
public int getMaxNumcommand() {
	return comserv.getMaxNumcommand();
}
//find order By Cart
@GetMapping(value = "/getorderbycart/{idcart}")
public Command findCommandByCart(@PathVariable ("idcart") int cartid) {
	return comserv.findCommandByCart(cartid);
}

//afficher historiques de commandes de chaque user 
@GetMapping(value = "/displayorderhistoryofeachuser/{idu}")
public List<Command > findCommandByUser(@PathVariable ("idu") int userid) {
	return comserv.findCommandByUser(userid);
}

//passer commande avec le montant de panier sans rediction et etat en cours de preparation jusquà valider la commande 
@PostMapping(value = "/passercommand/cart/{idc}")
public String affecterCartACommand(@PathVariable ("idc") int cartId) {
	return comserv.affecterCartACommand(cartId);
}
/*
//affecterCommandAUser
@PutMapping(value = "/affecterCommandAUser/{iduser}/{idcmd}")
public void affecterCommandAUser(@PathVariable ("iduser") int userId,@PathVariable ("idcmd") int commandId) {
	comserv.affecterCommandAUser(userId, commandId);
}

//AjouterCommand
@PostMapping(value = "/AjouterCommand")
public ResponseEntity<Object> AjouterCommand(@Valid @RequestBody Command c) {
	return comserv.AjouterCommand(c);
}*/
//deleteCommandById
@DeleteMapping(value = "/deleteCommandById/{idcom}")
public String deleteCommandById(@PathVariable("idcom") int idc) {
return 	comserv.deleteCommandById(idc);
}
/*
//addOrUpdateCommand
@PostMapping(value = "/addOrUpdateCommand")
public ResponseEntity<String> addOrUpdateCommand(@Valid @RequestBody Command c) {
	return comserv.addOrUpdateCommand(c);
}
*/
//selectAll commande order by date
@GetMapping(value = "/selectAllorderbydate")
public List<Command> selectAll() {
	return comserv.selectAllorderbydate();
}
//servlet/getAmountCommand
@GetMapping(value = "/getAmountfromCommand/{idcart}")
public String getAmountCommand(@PathVariable("idcart") int cartId)  {
		return comserv.getAmountCommand(cartId);
	}
/*
//creercommande
@PostMapping(value = "/creercommande")
public void creercommande() {
	comserv.creercommande();
}*/
//modifiercommande
@PutMapping(value = "/modifiercommande")
public ResponseEntity<String> modifiercommande(@Valid @RequestBody Command commande) {
return	comserv.modifiercommande(commande);
}

//countBetween
@GetMapping(value = "/countBetween/{d1}/{d2}")
public Integer countBetween(@PathVariable("d1") @DateTimeFormat(pattern = "dd-MM-yyyy") Date d1,@PathVariable("d2") @DateTimeFormat(pattern = "dd-MM-yyyy") Date d2) {
	return comserv.countBetween(d1, d2);
}
/*
//saveCommande
@PostMapping(value = "/saveCommande/{Amount}/{idc}/{idu}/{mp}/{vp}")
public void saveCommande( @PathVariable("Amount")double AmountCommand,@PathVariable("idc")int cartId,@PathVariable("idu")int userid ,@PathVariable("mp")ModePayement payement,@PathVariable("vp")Boolean validpayement) {
	comserv.saveCommande(AmountCommand,cartId, userid, payement, validpayement);
}
*/

//findByOrderByOrderDatecreationDesc
@GetMapping(value = "/findByOrderByOrderDatecreationDesc")
public List<Command> findByOrderByOrderDatecreationDesc() {
return comserv.findByOrderByOrderDatecreationDesc();	
}

//cancel
@PutMapping(value = "/cancel/{id}")
public void cancel(@PathVariable("id") int id) {
	comserv.cancel( id);
}

//count
@GetMapping(value = "/count/{x}")
public long count(@PathVariable("x") Etat etat) {
	return comserv.count(etat);
}

//findByEtatOrderByDatecreationDesc
@GetMapping(value = "/findByEtatOrderByDatecreationDesc/{x}")
public List<Command> findByEtatOrderByDatecreationDesc(@PathVariable("x") Etat etat) {
	return comserv.findByEtatOrderByDatecreationDesc(etat);
}

//findByPayement
@GetMapping(value = "/findByPayement/{x}")
public List<Command> findByPayement(@PathVariable("x") ModePayement payement) {
	return comserv.findByPayement(payement);
}

//updatestatus
@GetMapping(value = "/updatestatus/{vp}/{idc}")
public String updatestatus(@PathVariable("vp") Boolean validpayement,@PathVariable("idc")int idcmd) {
	return comserv.updatestatus(validpayement, idcmd);
}

//updatestatusbydelivred
@GetMapping(value = "/updatestatusbydelivred/delivery/{idd}/command/{idc}")
public String updatestatusbydelivred( @PathVariable("idd") int iddelivery,@PathVariable("idc") int idcmd) {
	return comserv.updatestatusbydelivred(iddelivery, idcmd);
}


//findByDateCreation
@GetMapping(value = "/findByDateCreation/{datec}")
public Command findByDateCreation(@PathParam("datec") @DateTimeFormat(pattern = "dd-MM-yyyy") Date datecreation) {
	return comserv.findByDateCreation(datecreation);
}

//findAllByDateCreation
@GetMapping(value = "/findAllByDateCreation/{datec}")
public List<Command> findAllByDateCreation(@PathParam("datec") @DateTimeFormat(pattern = "dd-MM-yyyy") Date datecreation) {
	return comserv.findAllByDateCreation(datecreation);
}
//pay in 3 months 
@PutMapping(value = "/payin3months/cmd/{idcmd}/compte/{idcpt1}/{idcpt2}/{iddeliv}")
public String payinthreemonths(@PathVariable("idcmd") int idc ,@PathVariable("idcpt1") int cpte1,@PathVariable("idcpt2")  int cpte2 ,@PathVariable("iddeliv")int deliveryid) {
	return comserv.payinthreemonths(idc, cpte1, cpte2,deliveryid);
}
@PutMapping(value = "/addprogrammefidelite/{idf}")
public String  addprogrammefidelite (@PathVariable("idf") int idfidel  ) {
	return comserv.addprogrammefidelite(idfidel);
}
@PutMapping(value = "/paymentbyfidelite/user/{userid}/{idcpt2}/{iddeliv}")
public String paymentbyfidelite(@PathVariable("userid") int userid ,@PathVariable("idcpt2")  int cpte2,@PathVariable("iddeliv")int deliveryid) {
	return comserv.paymentbyfidelite(userid,   cpte2,deliveryid);
}
//pay in 6 months
@PutMapping(value = "/payin6months/cmd/{idcmd}/compte/{idcpt1}/{idcpt2}/{iddeliv}")
public String payin6months(@PathVariable("idcmd") int idc ,@PathVariable("idcpt1") int cpte1,@PathVariable("idcpt2")  int cpte2,@PathVariable("iddeliv")int deliveryid ) {
	return comserv.payin6months(idc, cpte1, cpte2,deliveryid);
}
//pay in 9 months 
@PutMapping(value = "/payin9months/cmd/{idcmd}/compte/{idcpt1}/{idcpt2}/{iddeliv}")
public String payin9months(@PathVariable("idcmd") int idc ,@PathVariable("idcpt1") int cpte1,@PathVariable("idcpt2")  int cpte2,@PathVariable("iddeliv")int deliveryid ) {
	return comserv.payin9months(idc, cpte1, cpte2,deliveryid);
}
//pay in 12 months
@PutMapping(value = "/payin12months/cmd/{idcmd}/compte/{idcpt1}/{idcpt2}/{iddeliv}")
public String payin12months(@PathVariable("idcmd") int idcmd ,@PathVariable("idcpt1") int cpte1,@PathVariable("idcpt2")  int cpte2 ,@PathVariable("iddeliv")int deliveryid) {
	return comserv.payin12months(idcmd, cpte1, cpte2,deliveryid);
}

@DeleteMapping(value = "/clean up")
public void performCommandCleanup() {
	comserv.performCommandCleanup();
}
@PutMapping(value = "/reductionsurcommande/{idcart}")
public String reductionsurcommande(@PathVariable("idcart")int idcart) {
	return comserv.reductionsurcommande( idcart);
}
}
