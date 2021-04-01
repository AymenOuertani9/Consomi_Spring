package tn.esprit.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;
import tn.esprit.pidev.repository.IProductRepository;
import tn.esprit.pidev.repository.IStockRepository;

@Service
public class StockService implements IStockService{
	@Autowired
	IProductRepository prodrep;
	@Autowired
	IStockRepository stock;
	public void AddQStock(int prodID, float quan) {
		// TODO Auto-generated method stub
		Product prod= prodrep.findById(prodID).orElse(null);
		Stock st=stock.findByproducts(prod);
		float qex = st.getQuantity();
		st.setQuantity(quan + qex);
		stock.save(st);
	}
}
