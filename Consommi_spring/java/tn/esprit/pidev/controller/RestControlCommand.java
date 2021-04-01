package tn.esprit.pidev.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.ModePayement;
import tn.esprit.pidev.entities.Remarque;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.service.ICommandeService;
import tn.esprit.pidev.service.IRemarqueService;

@RestController
public class RestControlCommand {
@Autowired
ICommandeService comserv;

// URL : http://localhost:8081/SpringMVC/servlet/getCommandes
@GetMapping(value = "/getCommandes")
public List<Command> getCommandes(){
	return comserv.getCommandes();
}
/*
// URL : http://localhost:8081/SpringMVC/servlet/getCommandesOfClient/89/v/2021-02-24/2021-02-09/9996/enligne/true
@GetMapping(value = "/getCommandesOfClient/{num}/{etat}/{dates}/{datec}/{amount}/{modep}/{validp}")
public List<Command> getCommandesOfClient(@PathVariable("num")int numcommand,@PathVariable("etat") String Etat,@PathVariable("dates") Date DateSend,@PathVariable("datec") Date DateCreation,
		@PathVariable("amount") double AmountCommand,@PathVariable("modep")  ModePayement payement,@PathVariable("validp")  Boolean validpayement){
	return comserv.getCommandesOfClient(numcommand, Etat, DateSend, DateCreation, AmountCommand, payement, validpayement);
}*/

// URL : http://localhost:8081/SpringMVC/servlet/getCommande/{idc}
@GetMapping(value = "/getCommande/{idc}")
public Command getCommande(@PathVariable ("idc")int idcommand) {
	return comserv.getCommande(idcommand);
}

//URL : http://localhost:8081/SpringMVC/servlet/getMaxNumcommand
@GetMapping(value = "/getMaxNumcommand")
public int getMaxNumcommand() {
	return comserv.getMaxNumcommand();
}
//URL : http://localhost:8081/SpringMVC/servlet/findCommandByCart/{idcart}
@GetMapping(value = "/findCommandByCart/{idcart}")
public Command findCommandByCart(@PathVariable ("idcart") int cartid) {
	return comserv.findCommandByCart(cartid);
}

//URL : http://localhost:8081/SpringMVC/servlet/findCommandByUser/{idu}
@GetMapping(value = "/findCommandByUser/{idu}")
public List<Command > findCommandByUser(@PathVariable ("idu") int userid) {
	return comserv.findCommandByUser(userid);
}

//URL : http://localhost:8081/SpringMVC/servlet/affecterCartACommand/{idc}/{idcmd}
@PutMapping(value = "/affecterCartACommand/{idc}/{idcmd}")
public void affecterCartACommand(@PathVariable ("idc") int cartId,@PathVariable ("idcmd")  int commandId) {
	comserv.affecterCartACommand(cartId, commandId);
}

//URL : http://localhost:8081/SpringMVC/servlet/affecterCommandAUser/{iduser}/{idcmd}
@PutMapping(value = "/affecterCommandAUser/{iduser}/{idcmd}")
public void affecterCommandAUser(@PathVariable ("iduser") int userId,@PathVariable ("idcmd") int commandId) {
	comserv.affecterCommandAUser(userId, commandId);
}

//URL : http://localhost:8081/SpringMVC/servlet/AjouterCommand
@PostMapping(value = "/AjouterCommand")
public Command AjouterCommand(@RequestBody Command c) {
	return comserv.AjouterCommand(c);
}
//URL : http://localhost:8081/SpringMVC/servlet/deleteCommandById/{idcom}
@DeleteMapping(value = "/deleteCommandById/{idcom}")
public void deleteCommandById(@PathVariable("idcom") int comandId) {
	comserv.deleteCommandById(comandId);
}

//URL : http://localhost:8081/SpringMVC/servlet/addOrUpdateCommand
@PostMapping(value = "/addOrUpdateCommand")
public int addOrUpdateCommand(@RequestBody Command c) {
	return comserv.addOrUpdateCommand(c);
}

//URL : http://localhost:8081/SpringMVC/servlet/selectAll
@GetMapping(value = "/selectAll")
public List<Command> selectAll() {
	return comserv.selectAllorderbydate();
}
//URL : http://localhost:8081/SpringMVC/servlet/getCartTotalById/{idcart}/{tva}/{iddeliv}
@GetMapping(value = "/getCartTotalById/{idcart}/{tva}/{iddeliv}")
public double getAmountCommand(@PathVariable("idcart") int cartId,@PathVariable("tva")int tva,@PathVariable("iddeliv")int deliveryid)  {
		return comserv.getAmountCommand(cartId, tva, deliveryid);
	}

//URL : http://localhost:8081/SpringMVC/servlet/creercommande
@PostMapping(value = "/creercommande")
public void creercommande() {
	comserv.creercommande();
}
//URL : http://localhost:8081/SpringMVC/servlet/modifiercommande
@PutMapping(value = "/modifiercommande")
public void modifiercommande(@RequestBody User user) {
	comserv.modifiercommande(user);
}

//URL : http://localhost:8081/SpringMVC/servlet/countBetween/{d1}/{d2}
@GetMapping(value = "/countBetween/{d1}/{d2}")
public Integer countBetween(@PathVariable("d1") @DateTimeFormat(pattern = "dd-MM-yyyy") Date d1,@PathVariable("d2") @DateTimeFormat(pattern = "dd-MM-yyyy") Date d2) {
	return comserv.countBetween(d1, d2);
}

//URL : http://localhost:8081/SpringMVC/servlet/saveCommande/{Amount}/{idc}/{idu}/{mp}/{vp}
@PostMapping(value = "/saveCommande/{Amount}/{idc}/{idu}/{mp}/{vp}")
public void saveCommande( @PathVariable("Amount")double AmountCommand,@PathVariable("idc")int cartId,@PathVariable("idu")int userid ,@PathVariable("mp")ModePayement payement,@PathVariable("vp")Boolean validpayement) {
	comserv.saveCommande(AmountCommand,cartId, userid, payement, validpayement);
}


//URL : http://localhost:8081/SpringMVC/servlet/findByOrderByOrderDatecreationDesc
@GetMapping(value = "/findByOrderByOrderDatecreationDesc")
public List<Command> findByOrderByOrderDatecreationDesc() {
return comserv.findByOrderByOrderDatecreationDesc();	
}

//URL : http://localhost:8081/SpringMVC/servlet/cancel/{id}
@PutMapping(value = "/cancel/{id}")
public void cancel(@PathVariable("id") int id) {
	comserv.cancel( id);
}

}
