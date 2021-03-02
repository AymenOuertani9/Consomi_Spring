package tn.esprit.pidev.service;

public interface IStockService {
	
	void AddStock(int prodID, float quan);
	
	String CommandeStock(int prodID, float quan);

}
