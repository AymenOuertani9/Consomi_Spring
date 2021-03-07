package tn.esprit.pidev.service;

import java.util.List;

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
	public void AddQStock(int prodID, float quan) {
		// TODO Auto-generated method stub
		Product prod= product.findById(prodID).orElse(null);
		Stock st=stock.findByproducts(prod);
		float qex = st.getQuantity();
		st.setQuantity(quan + qex);
		stock.save(st);
	}
	@Override
	public String CommandeStock(int prodID,float quan) {
		// TODO Auto-generated method stub
		Product prod= product.findById(prodID).orElse(null);
		Stock st=stock.findByproducts(prod);
		float qex = st.getQuantity();
		if(qex >= quan){
			st.setQuantity(qex - quan);
			stock.save(st);
			return "ok";
		} else if (qex < quan){
			return "Cant previde this quantity";
		} else return "Product Solde Out";
	}
	@Override
	public void AddStock(Stock nstock) {
		// TODO Auto-generated method stub
		stock.save(nstock);
	}
	@Override
	public Stock getStockByProduct(int prodID) {
		// TODO Auto-generated method stub
		Product prod= product.findById(prodID).orElse(null);
		Stock st=stock.findByproducts(prod);
		return st;
	}
	@Override
	public List<Stock> getStockbyQuantity(float quan) {
		// TODO Auto-generated method stub
		return stock.findByQuantity(quan);
	}
	
		
	}
	