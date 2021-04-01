package tn.esprit.pidev.service;

import java.util.Date;
import java.util.List;

import tn.esprit.pidev.entities.Cart;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.User;




public interface ICartService {

	
	public List<Cart>getcartByIduser(int iduser);
	public Cart getCartById(int cartId);
	public String affecterCartAUser(int userId, int cartId);
	public double getCartTotalById(int lcId, int cartId);
	
	
	
	//public Cart enregistrerCart(Cart cart);
	
	public void deleteCartById(int cartId);
	//public List<String> getAllCartProductsnames(int cartId);
//	public void mettreAjourProductByCartId(String name, int cartId,int productid);
	public int addOrUpdateCart(Cart cart);
	//public List<Product> getAllCartProducts(int cartId);
	////public void viderpanier(int cartId);
	
	public String ajouteretaffecterUserACart(Cart cart, int userId);

	
	public double getTotalcart(int cartId);
	public List<Cart>listcartitems();
	
	//public Cart fndByUserAndProduct(User user, Product p);
	
}