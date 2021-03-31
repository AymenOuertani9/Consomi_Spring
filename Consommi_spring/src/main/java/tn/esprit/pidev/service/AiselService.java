package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Aisel;
import tn.esprit.pidev.entities.Category;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.repository.IAiselRepository;
import tn.esprit.pidev.repository.ICategoryRepository;
import tn.esprit.pidev.repository.IProductRepository;

@Service
public class AiselService implements IAiselService {
	
	@Autowired
	IAiselRepository aiselrepository;
	
	@Autowired
	ICategoryRepository categoryrepository;
	
	@Autowired
	IProductRepository productrepository;
	

	@Override
	public int AddAisel(Aisel aisel) {
		// TODO Auto-generated method stub
		aiselrepository.save(aisel);
		return aisel.getIdAisel();
		
	}

	@Override
	public String Mod_Aisel(int aiselId, Aisel aisel) {
		// TODO Auto-generated method stub
		Aisel aise=aiselrepository.findById(aiselId).orElse(null);
		aisel = aise;
		aiselrepository.save(aisel);
		return "Aisel Updated";
	}

	@Override
	public String Del_Aisel(int aiselId) {
		// TODO Auto-generated method stub
		Aisel aise=aiselrepository.findById(aiselId).orElse(null);
		aiselrepository.delete(aise);
		return "Aisel Deleted";
	}

	@Override
	public List<Aisel> GetAllAisel() {
		// TODO Auto-generated method stub
		return (List<Aisel>) aiselrepository.findAll();
		
	}

	@Override
	public void AffectProdctToAisel(String CatName,int aiselId) {
		
		Category cat=categoryrepository.findCategoryByname(CatName);
		List<Product> prod=productrepository.findBycategory(cat);
		Aisel aisel=aiselrepository.findById(aiselId).orElse(null); 
		aisel.setProducts(prod);
		
	}

	@Override
	public String AffecterSpecificProduct(int aiselId, int prodId) {
		// TODO Auto-generated method stub
		Aisel aisel=aiselrepository.findById(aiselId).orElse(null); 
		Product prod=productrepository.findById(prodId).orElse(null);
		if(aisel.getCapacitymax()==aisel.getProducts().size()){
			
			return "This Aisel is Full if you want delete one product";
			
		}else {
			aisel.getProducts().set(aisel.getProducts().size()+1, prod);
			return "the Product has been succefully added to the aisel";
		}
		
		
		
	}

	@Override
	public String DeleteSpecificProduct(int aiselId, int prodId) {
		Aisel aisel=aiselrepository.findById(aiselId).orElse(null); 
		Product prod=productrepository.findById(prodId).orElse(null);
		List<Product> products=aisel.getProducts();
		products.forEach(product->{
		 if(prod.getIdProduct()==prodId){
			 aisel.getProducts().remove(prod); 
		 }
		}
		);
		return "The Product has been Deleted Succefully";
		
	}
}
	
	
