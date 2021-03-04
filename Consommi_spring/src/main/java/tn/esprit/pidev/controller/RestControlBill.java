package tn.esprit.pidev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.service.IBillService;

@RestController
public class RestControlBill {
@Autowired
IBillService facserv;
//URL : http://localhost:8081/SpringMVC/servlet/getBillByIduser/{userid}
@GetMapping(value = "/getBillByIduser/{userid}")
public List<Bill> getBillByIduser(@PathVariable("userid") int iduser) {
	return facserv.getBillByIduser(iduser);
}
//URL : http://localhost:8081/SpringMVC/servlet/getBillById/{idbill}
@GetMapping(value = "/getBillById/{idbill}")
public Bill getBillById(@PathVariable("idbill") int billId) {
	return facserv.getBillById(billId);
}

//URL : http://localhost:8081/SpringMVC/servlet/AjouterFacture
@PostMapping(value = "/AjouterFacture")
public Bill AjouterFacture(@RequestBody Bill bill) {
	return facserv.AjouterFacture(bill);
}

//URL : http://localhost:8081/SpringMVC/servlet/getBillTotalById/{idbill}
@GetMapping(value = "/getBillTotalById/{idbill}")
public double getBillTotalById(@PathVariable("idbill") int billId) {
	return facserv.getBillTotalById(billId);
}

//URL : http://localhost:8081/SpringMVC/servlet/deleteBillById/{idbill}
@DeleteMapping(value = "/deleteBillById/{idbill}")
public void deleteBillById(@PathVariable("idbill") int billId) {
	facserv.deleteBillById(billId);
}

//URL : http://localhost:8081/SpringMVC/servlet/getAllBill
@GetMapping(value = "/getAllBill")
public List<Bill> getAllBill() {
	return facserv.getAllBill();
}
//URL : http://localhost:8081/SpringMVC/servlet/addOrUpdateBill
@PostMapping(value = "/addOrUpdateBill")
public int addOrUpdateBill(@RequestBody Bill bill) {
	return facserv.addOrUpdateBill(bill);
}
//URL : http://localhost:8081/SpringMVC/servlet/ajouteretaffecterUserABill/{iduser}
@PostMapping(value = "/ajouteretaffecterUserABill/{iduser}")
public void ajouteretaffecterUserABill(@RequestBody Bill bill,@PathVariable("iduser") int userId) {
	facserv.ajouteretaffecterUserABill(bill, userId);
}
}
