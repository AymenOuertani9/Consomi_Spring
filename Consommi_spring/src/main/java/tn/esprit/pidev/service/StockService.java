package tn.esprit.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;
import tn.esprit.pidev.repository.IProductRepository;
import tn.esprit.pidev.repository.IStockRepository;

@Service
public class StockService implements IStockService {
	
	@Autowired
	IProductRepository product;
	@Autowired
	IStockRepository stock;
	@Override
	public void AddStock(int prodID, float quan) {
		// TODO Auto-generated method stub
		Stock st=stock.findbyidProduct(prodID);
		float qex = st.getQuantity();
		st.setQuantity(quan + qex);
	}
	@Override
	public String CommandeStock(int prodID,float quan) {
		// TODO Auto-generated method stub
		Stock st=stock.findbyidProduct(prodID);
		float qex = st.getQuantity();
		if(qex >= quan){
			st.setQuantity(qex - quan);
			return "ok";
		} else if (qex < quan){
			return "Cant previde this quantity";
		} else return "Product Solde Out";
	}
	
	
	
	

}
