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
		
		return (List<supplier>) supplierrepository.findbyProduct(Product_Name);
	}

	@Override
	public String AddSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Mod_Supplier(int SuppId, supplier supplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Del_Supplier(int SuppID) {
		// TODO Auto-generated method stub
		return null;
	}

}
