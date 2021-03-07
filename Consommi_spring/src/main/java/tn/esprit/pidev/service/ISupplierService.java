package tn.esprit.pidev.service;

import java.util.List;

import tn.esprit.pidev.entities.supplier;

public interface ISupplierService {
	
	List<supplier> getAllSuppliers();
	List<supplier> getSupplierByProduct(String Product_Name);
	String AddSupplier(supplier supplier);
	String Mod_Supplier(int SuppId,supplier supplier);
	String Del_Supplier(int SuppID);

}
