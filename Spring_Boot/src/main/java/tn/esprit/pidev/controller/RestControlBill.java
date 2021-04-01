package tn.esprit.pidev.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.TypeFacture;
import tn.esprit.pidev.service.IBillService;

@RestController
public class RestControlBill {
@Autowired
IBillService facserv;

//afficher les factures de chaque user
@GetMapping(value = "/getbillbyuser/{userid}")
public List<Bill> getBillByIduser(@PathVariable("userid") int iduser) {
	return facserv.getBillByIduser(iduser);
}

//afficher chaque bill
@GetMapping(value = "/getbillbyid/{idbill}")
public Bill getBillById(@PathVariable("idbill") int billId) {
	return facserv.getBillById(billId);
}

//ajouter bill avec validation de (le num et le total doivent etre positive , la date de reglement et la date facture doivent etre au present ou au future)
@PostMapping(value = "/addbill")
public String AddBill(@Valid @RequestBody Bill bill) {
	return facserv.AddBill(bill);
}

//afficher le total de chaque facture
@GetMapping(value = "/gettotalbillbyid/{idbill}")
public double getBillTotalById(@PathVariable("idbill") int billId) {
	return facserv.getBillTotalById(billId);
}

//supprimer facture avec cascade
@DeleteMapping(value = "/deletebyid/{idbill}")
public String deleteBillById(@PathVariable("idbill") int billId) {
	return facserv.deleteBillById(billId);
}

//afficher tous les factures
@GetMapping(value = "/getallbill")
public List<Bill> getAllBill() {
	return facserv.getAllBill();
}
//ajouter ou modifier facture avec validation 
@PostMapping(value = "/addorupdatebill")
public String addOrUpdateBill(@Valid @RequestBody Bill bill) {
	return facserv.addOrUpdateBill(bill);
}
/*
//ajouter et affecter un bill a chaque user 
@PostMapping(value = "/addandassignuserabill/{iduser}")
public void addandassignUserABill(@RequestBody Bill bill,@PathVariable("iduser") int userId) {
	facserv.addandassignUserABill(bill, userId);
}
*/
//chercher facture par son numero
@GetMapping(value = "/findbynum/{num}")
public Bill find(@PathVariable("num") int numero) {
	return facserv.find(numero);
}

//calcul de la moyenne des achats (la moyenne de somme de total final de facture)
@GetMapping(value = "/moyendesachats")
public Double PricesPurchasesProducts() {
	return facserv.PricesPurchasesProducts();
}
/*
//affecter bill au user
@PutMapping(value = "/assignuserabill/{billId}/{iduser}")
public String assignUserABill(@PathVariable("billId") int billId,@PathVariable("iduser") int userId) {
	return facserv.assignUserABill(billId, userId);
}
*/
//affecter commande a facture
@PutMapping(value = "/assignorderabill/{billId}/{idorder}")
public String assignOrderABill(@PathVariable("billId") int billId,@PathVariable("idorder") int orderId) {
	return facserv.assignOrderABill(billId, orderId);
}

//add and assign Order A Bill
@PostMapping(value = "/addandassignorderabill/{idorder}")
public String addandassignOrderABill(@RequestBody Bill bill,@PathVariable("idorder") int orderId) {
	return facserv.addandassignOrderABill(bill, orderId);
}

//chercher facture par commande
@GetMapping(value = "/getbillbyorder/{idorder}")
public List<Bill> getBillByIdorder(@PathVariable("idorder") int idorder) {
	return facserv.getBillByIdorder(idorder);
}
//calculer les nbr de factures 
@GetMapping(value = "/count")
public long count() {
	return facserv.count();
}


//chercher facture par type facture automatique ou manuelle
@GetMapping(value = "/findbytype/{typefac}")
public List<Bill> findBYtype(@PathVariable("typefac") TypeFacture tupefac) {
	return facserv.findBYtype(tupefac);
}


// get all bill between date bill d1 and d2
@GetMapping(value = "/getallbillbetweendate/{d1}/{d2}")
public List<Bill> getallbillbetwendate(@DateTimeFormat(pattern = "dd-MM-yyyy")  Date d1, @DateTimeFormat(pattern = "dd-MM-yyyy") Date d2) {
	return facserv.getallbillbetwendate(d1, d2);
}

//calculer la moyenne des achats par jour 
@GetMapping(value = "/getmoyenbillbyday/command/{p}/annee/{a}/mois/{m}/jour/{j}")
public List<Object[]> getMoyenBillJour(@PathVariable("p") int idcommand,@PathVariable("a")Integer a, @PathVariable("m")Integer m, @PathVariable("j")Integer j){
	return facserv.getMoyenBillJour(idcommand, a, m, j);
}

//calculer la moyenne des achats par mois
@GetMapping(value = "/getmoyenbillbymonth/command/{p}/annee/{a}/mois/{m}")
public List<Object[]> getMoyenBillMonth(@PathVariable("p") int idcommand,@PathVariable("a")Integer a, @PathVariable("m")Integer m) {
	return facserv.getMoyenBillMonth(idcommand, a, m);
}

//calculer la moyenne des achats par année
@GetMapping(value = "/getmoyenbillbyyear/command/{p}/annee/{a}")
public List<Object[]> getMoyenBillyear(@PathVariable("p") int idcommand,@PathVariable("a")Integer a) {
return facserv.getMoyenBillyear(idcommand, a);	
}


//chercher facture par date de reglement

@GetMapping(value = "/getbillbydatereglement/{datereglmt}")
public List<Bill> getBillBydatereglement(@DateTimeFormat(pattern = "dd-MM-yyyy") Date datereglmt) {
	return facserv.getBillBydatereglement(datereglmt);
}


//chercher facture par date bill
@GetMapping(value = "/getbillbydatebill/{d1}")
public List<Bill> getBillBydatebill(@PathVariable("d1") @DateTimeFormat(pattern = "dd-MM-yyyy") Date datebill) {
	return facserv.getBillBydatebill(datebill);
}

//afficher les factures dont le total >1000
@GetMapping(value = "/getbillbytotalsup")
public List<Bill> getBillBytotalfinalsup() {
	return facserv.getBillBytotalfinalsup();
}

//afficher les moyennes des achats entre date d1 et d2 
@GetMapping(value = "/prixAchatsProduitsbetwend1andd2/{d1}/{d2}")
public Double prixAchatsProduitsbetwend1andd2(@PathVariable("d1") @DateTimeFormat(pattern = "dd-MM-yyyy") Date d1,@PathVariable("d2") @DateTimeFormat(pattern = "dd-MM-yyyy") Date d2) {
	return facserv.prixAchatsProduitsbetwend1andd2(d1, d2);
}

//afficher total de facture de chaque user , le total c le prix ttc = htva (somme de tous les commandes d'un seul user+fris de livraison *tva)+htva
@GetMapping(value = "/gettotalbill/cart/{idcart}")
public String  gettotalbill( @PathVariable("idcart") int idc) {
	return  facserv.gettotalbill(idc);
}
@PutMapping(value = "/setetatbill/{idcart}")
public String setetatbill(@PathVariable("idcart") int idc) {
	return facserv.setetatbill(idc);
}
}