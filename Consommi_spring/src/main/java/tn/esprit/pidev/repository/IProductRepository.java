package tn.esprit.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;

@Repository
public interface IProductRepository extends CrudRepository<Product,Integer> {

	
}
