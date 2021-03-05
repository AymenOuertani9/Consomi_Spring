package tn.esprit.pidev.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.supplier;

@Repository
public interface ISupplierRepository extends CrudRepository<supplier,Integer> {
	
	List<supplier> findbyProduct(String P_Name);

}
