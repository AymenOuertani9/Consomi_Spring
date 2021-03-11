package tn.esprit.pidev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.supplier;
import tn.esprit.pidev.service.SupplierService;

@RestController
public class SupplierRestController {

	@Autowired
	SupplierService supplierservice;
	
	@GetMapping("/Allsupplier")
	@ResponseBody
	public void getAllSupplier(){
		
		supplierservice.getAllSuppliers();
	}
	
	@GetMapping("/Supplier/{pName}")
	@ResponseBody
	public void getSupplierByProduct(@PathVariable("pName") String pName){
		supplierservice.getSupplierByProduct(pName);
	}
	
	@PostMapping("/AddSupplier")
	@ResponseBody
	public void AddSupplier(@RequestBody supplier supplier){
		
		supplierservice.AddSupplier(supplier);
	}
	
	@PutMapping("/ModSupplier/{IdSupp}/{Supp}")
	@ResponseBody
	public void ModSupplier(@PathVariable("IdSupp")int SuppId,@PathVariable("Supp") supplier supplier){
		
		supplierservice.Mod_Supplier(SuppId, supplier);
	}
	
	@DeleteMapping("/DelSupplier/{SuppId}")
	@ResponseBody
	public void DelSupplier(@PathVariable("SuppId")int SuppID){
		
		supplierservice.Del_Supplier(SuppID);
	}
}
