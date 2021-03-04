package tn.esprit.pidev.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.repositories.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	IProductRepository iProductRepository;
	/************************************VerifyProduct**************************************/
	@Override
	public boolean verifyProduct(String barCode) {
		    {
				System.out.println(barCode);
				if (barCode.trim().startsWith("619")) {
					return true;
				} else
					return false;
			}
		   
	}
	/**********************Creating add method that insert product into database***************/
	@Override
	public int addProduct(Product product) {
		
		product.setCreatedAt(new Date());
		if(product.getBarCode().startsWith("619")){
			iProductRepository.save(product);
			return product.getIdProduct();
		}
		return -1;


			
	}
	/****************Creating update method that upgrade product from database*****************/ 
    @Override
	public void updateProduct(Product p, int idProduct) {
    	
		Product product = iProductRepository.findById(idProduct).get();
		product.setProductName(p.getProductName());
		product.setCreatedAt(p.getCreatedAt());
		product.setBuyPrice(p.getBuyPrice());
		product.setTva(p.getTva());
		product.setDescription(p.getDescription());
		product.setSellPrice(p.getSellPrice());
		product.setPicture(p.getPicture());
		product.setWeigth(p.getWeigth());
		product.setNewProduct(p.isNewProduct());
		product.setCreatedAt(new Date());
		iProductRepository.save(product);
		
	}
    /*******************Creating deleting method that remove product by id  from database*********/
	@Override
	public int deleteProduct(int idProduct) {
		Product product = iProductRepository.findById(idProduct).get();
		iProductRepository.delete(product);
		return idProduct;
	}
	/***************Creating getAll method that retrieve all product from database **************/
    @Override
	public List<Product> getAllProducts() {
		return (List<Product>)iProductRepository.findAll();
	}
    /**************Creating getByid method that retrieve product detail from database************/
	@Override
	public Product getProductById(int id) {
		return iProductRepository.findById(id).get();  
	}
	/***************Creating getAll product by category method from database **************/
	@Override
	public List<Product>getProductsByCategory(String categoryName) {
		List<Product>productsList = new ArrayList<>();
		List<Product>getProducts = (List<Product>) iProductRepository.findAll();
		for(Product p : getProducts) {
			
			if(p.getCategory().getName().equals(categoryName)) {
				productsList.add(p);
			}
		}
		return productsList;
	}
	/******************Creating getAll product by name method from database ********************/
	@Override
	public Product findProductByName(String name) {
		return iProductRepository.findProductByName(name);
	}
	
	/****************Search product by Name and categoryName*********************/
	@Override
	public List<Product> searchProducts(String productName, String categoryName) {
		List<Product> products=(List<Product>) iProductRepository.findAll();
		boolean containsProd=true;
		boolean containsCat=true;
		List<Product> result=  new ArrayList<>();
		if ((productName==null)||(productName=="")) containsProd=false;
		if ((categoryName==null)||(categoryName=="")) containsCat=false;
		//if (!containsProd && !containsCat) return result;
		int nbProducts=products.size();	
		Product product=new Product();	
		if(!containsProd) {
			for(int i=0 ; i< nbProducts ; i++) {
				product = products.get(i);
				
				containsCat = true;
				
				if(product.getCategory().getName() == null) {
					containsCat =false;
					return null;
				}
				else {
					containsCat = product.getCategory().getName().contains(categoryName);
				}
				if(containsCat ==true) {
					
					result.add(product);
				}
		}
	
	}
		else 
			for(int i=0 ; i< nbProducts ; i++) {
				product = products.get(i);
				containsProd = true;
				
				if(product.getProductName() == null) {
					containsProd =false;
				}
				else {
					containsProd = product.getProductName().contains(productName);
				}
				if(containsProd ==true) {
					result.add(product);
				}
		}
		
	
		return result;
	}
	/*************************Search product by BarCode ******************************/
	@Override
	public Product findProductByBarCode(String barCode) {
		return iProductRepository.findProductByBarCode(barCode);
	}
	

	
}
