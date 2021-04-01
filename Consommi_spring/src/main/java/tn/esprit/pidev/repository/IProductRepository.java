package tn.esprit.pidev.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Category;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;

@Repository
public interface IProductRepository extends CrudRepository<Product,Integer> {
	
	List<Product> findByproductName(String Name);
	List<Product> findBycategory(Category category); 
	
}
