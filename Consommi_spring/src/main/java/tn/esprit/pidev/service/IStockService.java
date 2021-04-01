package tn.esprit.pidev.service;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;

public interface IStockService {
	
	Stock AddQStock(int prodID, float quan);
	String CommandeStock(int prodID, float quan);
	void AddStock(Stock stock);
	Stock getStockByProduct(int prodID);
	List<Stock> getStockbyQuantity(float quan);
	ArrayList<String> DailyStock();
	List<Product> ExpirationsNotif();
}
