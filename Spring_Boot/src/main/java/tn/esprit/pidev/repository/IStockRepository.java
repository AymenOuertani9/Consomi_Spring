package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Integer>{
	public Stock findByproducts(Product product);
}
