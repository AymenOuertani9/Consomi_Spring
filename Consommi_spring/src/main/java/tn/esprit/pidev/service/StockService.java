package tn.esprit.pidev.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;
import tn.esprit.pidev.entities.supplier;
import tn.esprit.pidev.repository.IProductRepository;
import tn.esprit.pidev.repository.IStockRepository;
import tn.esprit.pidev.repository.ISupplierRepository;

@Service
public class StockService implements IStockService {
	
	@Autowired
	IProductRepository product;
	@Autowired
	IStockRepository stockrepository;
	@Autowired
	ISupplierRepository supplierrepository;
	
	
	@Override
	public Stock AddQStock(int prodID, float quan) {
		// TODO Auto-generated method stub
		Product prod= product.findById(prodID).orElse(null);
		//System.out.println(prod);
		//Stock st=stockrepository.findByproduct(prod);
		Stock st=prod.getStock();
		//System.out.println(st);
		float qex = st.getQuantity();
		float newq=quan + qex;
		st.setQuantity(newq);
		stockrepository.save(st);
		return st;
	}
	@Override
	public String CommandeStock(int prodID,float quan) {
		// TODO Auto-generated method stub
		Product prod= product.findById(prodID).orElse(null);
		Stock st=stockrepository.findByproduct(prod);
		float qex = st.getQuantity();
		if(qex >= quan){
			st.setQuantity(qex - quan);
			stockrepository.save(st);
			return "ok";
		} else if (qex < quan){
			return "Cant previde this quantity, there is only "+ st.getQuantity();
		} else return "Product Solde Out";
	}
	@Override
	public void AddStock(Stock nstock) {
		// TODO Auto-generated method stub
		stockrepository.save(nstock);
	}
	@Override
	public Stock getStockByProduct(int prodID) {
		// TODO Auto-generated method stub
		Product prod= product.findById(prodID).orElse(null);
		Stock st=stockrepository.findByproduct(prod);
		return st;
	}
	@Override
	public List<Stock> getStockbyQuantity(float quan) {
		// TODO Auto-generated method stub
		return (List<Stock>) stockrepository.findByQuantity(quan);
	}
	@Override
	@Scheduled(cron="0 0 * * * ?")
	public ArrayList<String> DailyStock() {
		// TODO Auto-generated method stub
		ArrayList<String> daily=new ArrayList();
		List<Stock> stocks=(List<Stock>) stockrepository.findAll();		
		for(Stock stock : stocks){
			String name=stock.getProduct().getProductName();
			float quantity=stock.getQuantity();
			//return "Product Name"+name+":"+quantity;
			daily.add("Product Name :"+name+":"+quantity);
		}
		return daily;
		
	}
	@Override
	public List<Product> ExpirationsNotif() {
		List<Product> productstoCommande=new ArrayList();
		Iterable<Stock> stocks=stockrepository.findAll();
		for(Stock st : stocks)
			if(st.getQuantity()<= 10){
			productstoCommande.add(st.getProduct());
			}
		return productstoCommande;
	}
	
		
	}
	