package tn.esprit.pidev.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;
import tn.esprit.pidev.entities.supplying;
import tn.esprit.pidev.repository.IProductRepository;
import tn.esprit.pidev.repository.IStockRepository;
import tn.esprit.pidev.repository.ISupplyingRepository;


@Service
public class SupplyingService implements ISupplyingService {
	
	@Autowired
	ISupplyingRepository supplyingrepository;
	@Autowired
	IProductRepository productrepository;
	@Autowired
	IStockRepository stockrepository;
	@Override
	public String AddSupplying(supplying supplyin) {
		// TODO Auto-generated method stub
		supplyingrepository.save(supplyin);
		return "Supplying Added";
	}
	@Override
	public String FromSupplyingtoStock() {
		List<supplying> supplies=(List<supplying>) supplyingrepository.findAll();
		Stock s=new Stock();
		for(supplying supplie : supplies){
			System.out.print(new Date());
			System.out.println("ss"+supplie.getD_arrivale());
			System.out.println(LocalDate.now());
			if(supplie.getD_arrivale().toString().matches(LocalDate.now().toString())){
				System.out.println("yes");
				Product p=productrepository.findByproductName(supplie.getProduct());
				s=stockrepository.findByproduct(p);
				//System.out.println(productrepository.findByproductName(supplie.getProduct()));
				System.out.println(supplie.getProduct());
				System.out.println(s);
				
				if(s != null){
					s.setQuantity(s.getQuantity()+supplie.getQuantity());
					stockrepository.save(s);
					System.out.println(s);
				}else {
					
					Stock stck=new Stock();
					stck.setQuantity(supplie.getQuantity());
					stck.setProduct(p);
					stockrepository.save(stck);
					System.out.println(stck);
					
					
				}
			}
		}
		return "Added";
	}
	@Override
	public List<supplying> suppThisMonth() {
		List<supplying> Msupplies=new ArrayList<supplying>();
		List<supplying> supplies=(List<supplying>) supplyingrepository.findAll();
		for(supplying supplie : supplies){
			
			if(supplie.getD_arrivale().getMonth()==new Date().getMonth()){
				System.out.println("yes");
				Msupplies.add(supplie);
				
			}
			
		}
		
		return Msupplies;
	}
	@Override
	public ArrayList Mexpeses() {
		ArrayList tt=new ArrayList();
		List<supplying> Msupplies=new ArrayList<supplying>();
		float texp=0;
		List<supplying> supplies=(List<supplying>) supplyingrepository.findAll();
		for(supplying supplie : supplies){
			
			if(supplie.getDateCreation().getMonth()==new Date().getMonth()){
				texp=texp+supplie.getTot_coast();
				Msupplies.add(supplie);
				
			}
			
		}
		tt.add(Msupplies);
		tt.add(texp);
		return tt;
	}
	
	
	

}
