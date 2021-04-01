package tn.esprit.pidev.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Ads;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;
import tn.esprit.pidev.service.StockService;

@RestController
public class StockRestController {
	
	@Autowired
	StockService stockservice;
	
	@PutMapping("AddQStock/{prodId}")
	@ResponseBody
	public Stock AddQStock(@PathVariable("prodId")int prodID, @RequestBody float quan){
		
		return stockservice.AddQStock(prodID, quan);
	}
	
	
	@PutMapping("/CommandeStock/{prodId}/{quan}")
	@ResponseBody
	public String CommandeStock(@PathVariable("prodId")int prodID, @PathVariable("quan")float quan){
		
		return stockservice.CommandeStock(prodID, quan);
		
	}
	
	
	@PostMapping("AddStock")
	@ResponseBody
	public void AddStock(@RequestBody Stock stock){
		
		stockservice.AddStock(stock);		
	}
	
	@GetMapping("GetStock/{prodId}")
	@ResponseBody
	public Stock GetStockByProduct(@PathVariable("prodId") int ProductId){
		
		return stockservice.getStockByProduct(ProductId);
		
	} 
	
	@GetMapping("GetStockQuan/{quan}")
	@ResponseBody
	public List<Stock> GetStockByQuantity(@PathVariable("quan") float quan){
		
		List<Stock> list =stockservice.getStockbyQuantity(quan);
		return list;
	} 
	@GetMapping("DailyStock")
	@ResponseBody
	public ArrayList<String> DailyStock() {
		return stockservice.DailyStock();
	}
	
	@GetMapping("ExpirationsNotif")
	@ResponseBody
	public List<Product> ExpirationsNotif() {
		return stockservice.ExpirationsNotif();
	}
	


}
