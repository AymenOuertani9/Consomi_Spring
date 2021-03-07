package tn.esprit.pidev.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;

@Repository
public interface IStockRepository extends CrudRepository<Stock, Integer> {
	
	Stock findByproducts(Product product);
	List<Stock> findByQuantity(float quan);

}
