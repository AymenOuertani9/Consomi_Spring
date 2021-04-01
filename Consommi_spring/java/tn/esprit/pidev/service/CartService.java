package tn.esprit.pidev.service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.ICartRepository;
import tn.esprit.pidev.repository.ILigneCommandeRepository;
import tn.esprit.pidev.repository.IProductRepository;
import tn.esprit.pidev.repository.IUserRepository;


@Service
public class CartService implements ICartService {
@Autowired
ICartRepository cartrep;
@Autowired
IProductRepository produitrep;
@Autowired
IUserRepository userep;
@Autowired
ILigneCommandeRepository lcrep;
	@Override
	public List<Cart>getcartByIduser(int iduser) {
		
		return cartrep.getcartByIduser(iduser);
	}
	@Override
	public Cart getCartById(int cartId) {
		
		return cartrep.findById(cartId).orElse(null);
	}
/*	@Transactional
	public void affecterProductACart(int productId, int cartId) {
		Product produit =produitrep.findById(productId).get();
		Cart cart=cartrep.findById(cartId).get();
		if(cart.getProducts() == null){

			List<Product> produits = new ArrayList<>();
			produits.add(produit);
			cart.setProducts(produits);
		}else{

			cart.getProducts().add(produit);
		}

		 
		cartrep.save(cart); 

	}
	@Transactional
	public void desaffecterProductDuCart(int productId, int cartId) {
		Cart cart = cartrep.findById(cartId).get();

		int produitNb = cart.getProducts().size();
		for(int index = 0; index < produitNb; index++){
			if(cart.getProducts().get(index).getIdProduct() == productId){
				cart.getProducts().remove(index);
				break;
			}
		}
	}*/
	/*@Override
	public Cart enregistrerCart(Cart cart) {
		
		return cartrep.save(cart);
	}*/
	@Override
	public double getCartTotalById(int lcId,int cartId ) {
		LigneComand lc = lcrep.findById(lcId).get();
		Cart cart=cartrep.findById(cartId).get();
		
			double totalligne=lc.getQte()*(lc.getPrice());	
			double total=cart.getTotal();
		total=+totalligne;
		
	
		return total;}
	
	
	@Override
	public List<String> getAllCartProductsnames(int cartId) {
		return null;
	}
	@Override
	public void mettreAjourProductByCartId(String name, int cartId,int productid) {
		
		}
		
	
	
	@Override
	public int addOrUpdateCart(Cart cart) {
		cartrep.save(cart);
		return cart.getIdcart();
	}
/*	@Transactional
	public void affecterCartAUser(int userId, int cartId) {
		User user =userep.findById(userId).get();
		Cart cart=cartrep.findById(cartId).get();
		if(cart.getUser() == null){

			List<User> users = new ArrayList<>();
			users.add(user);
			cart.setUser(user);
		}else{

			cart.getUser();
		}

		 
		cartrep.save(cart); 

		*/
	
	@Override
	public List<Product> getAllCartProducts(int cartId) {
	return null;	
	}
	@Override
	public void deleteCartById(int cartId) {
		Cart cart = cartrep.findById(cartId).get();
		cartrep.delete(cart);

		
	}
	
	@Transactional
	public void ajouteretaffecterUserACart(Cart cart, int userId) {
		User user =userep.findById(userId).get();
		
		cart.setUser(user);
		cartrep.save(cart);
		
		
	}
	/*@Override
	public void addItem(Product p) {*/
		
		// int qte=0;
		 /*
		Map<Integer,LigneComand> items = new HashMap<Integer,LigneComand>();
		items.get(p.getIdProduct());
		if(lc==null) {
			lc.setProduit(p);
			lc.setQte(qte);
			lc.setPrice(p.getSellPrice());
			items.put(p.getIdProduct(), lc);
			}
	
	else {
		lc.setQte(lc.getQte()+qte);
	}
		ligncom.save(lc);
		}*/
		/*LigneComand lc =items.get(p.getIdProduct());
		if(lc==null) {
			LigneComand art = new LigneComand();
			art.setProduit(p);
			//art.setQte(qte);
			//art.setDate(date);
			art.setPrice(p.getSellPrice());
			items.put((long) p.getIdProduct(), art);
		}
		else {
			//lc.setQte(lc.getQte()+qte);
		}
		produitrep.save(p);*/
//	}

	@Override
	public Cart fndByUserAndProduct(User user, Product p) {
		
		return null;
				//cartrep.findByUserAndProduct(user, p);
	}
	@Override
	public Cart enregistrerCart(Cart cart) {
		
		return cartrep.save(cart);
	}
	@Override
	public List<Cart> listcartitems(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	}
	
	/*@Override
	public List<Cart> listcartitems(User user) {
		
		return null;
	}
	/*@Override
	public Integer addProduct(Integer idProduct,Integer qte,Integer iduser) {
		
		User user = userep.findById(iduser).get();
		Integer addedquantity =qte;
		Product product =produitrep.findById(idProduct).get();
		Cart cart = cartrep.findByUser(user);
		//for(Cart cart :carts) {
		if(cart!=null) {
			addedquantity=cart.getQte()+qte;
			cart.setQte(addedquantity);
			cart.setUser(user);
			List<Product> produits = new ArrayList<>();
			produits.add(product);
			cart.setProducts(produits);
			
			//cart.se
		}else {
			cart= new Cart();
			cart.setQte(addedquantity);
		}
		cartrep.save(cart);
		
	//}
		return addedquantity;
	}
	/*public float updateQuantity(Integer qte,Integer productid,User user) {
		cartrep.updateQuantity(qte, productid, user.getIduser());
		Product product =produitrep.findById(productid).get();
		float subtotal = product.getSellPrice()*qte;
		return subtotal;
	}*/
	
	


