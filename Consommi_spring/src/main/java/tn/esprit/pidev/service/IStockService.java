package tn.esprit.pidev.service;

import java.util.List;

import tn.esprit.pidev.entities.Stock;

public interface IStockService {
	
	void AddQStock(int prodID, float quan);
	
	String CommandeStock(int prodID, float quan);
	
	void AddStock(Stock stock);
	
	Stock getStockByProduct(int prodID);
	
	List<Stock> getStockbyQuantity(float quan);
}
