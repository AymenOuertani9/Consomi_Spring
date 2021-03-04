package tn.esprit.pidev.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Stock;

@Repository
public interface IStockRepository extends CrudRepository<Stock, Integer> {
	
	Stock findbyidProduct(int ProductId);
	List<Stock> findbyQuantity(float quan);

}
