package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.supplier;
import tn.esprit.pidev.repository.IProductRepository;
import tn.esprit.pidev.repository.ISupplierRepository;

@Service
public class SupplierService implements ISupplierService {
	
	@Autowired
	ISupplierRepository supplierrepository;
	
	@Autowired 
	IProductRepository productrepository;

	@Override
	public List<supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return (List<supplier>) supplierrepository.findAll();
	}

	@Override
	public List<supplier> getSupplierByProduct(String Product_Name) {
		
		return (List<supplier>) supplierrepository.findByProduct(Product_Name);
	}

	@Override
	public String AddSupplier(supplier supplier) {
		// TODO Auto-generated method stub
		supplierrepository.save(supplier);
		return "Supplier Added";
	}

	@Override
	public String Mod_Supplier(int SuppId, supplier supplier) {
		// TODO Auto-generated method stub
		supplier supp=supplierrepository.findById(SuppId).orElse(null);
		supplier = supp;
		supplierrepository.save(supplier);
		return "Supplier Update";
	}

	@Override
	public String Del_Supplier(int SuppID) {
		// TODO Auto-generated method stub
		supplier supp=supplierrepository.findById(SuppID).orElse(null);
		supplierrepository.delete(supp);
		return "Supplier Deleted";
	}

}
