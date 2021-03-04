package tn.esprit.pidev.service;

import java.util.Date;
import java.util.List;

import tn.esprit.pidev.entities.Cart;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.User;




public interface ICartService {
	public List<Cart>getcartByIduser(int iduser);
	public Cart getCartById(int cartId);
	public void affecterProductACart(int productId, int cartId);
	public void affecterCartAUser(int userId, int cartId);
	public void desaffecterProductDuCart(int productId, int cartId);
	public Cart enregistrerCart(Cart cart);
	public double getCartTotalById(int cartId ,int productId );
	public void deleteCartById(int cartId);
	public List<String> getAllCartProductsnames(int cartId);
	public void mettreAjourProductByCartId(String name, int cartId,int productid);
	public int addOrUpdateCart(Cart cart);
	public List<Product> getAllCartProducts(int cartId);
	public void viderpanier(int cartId);
	public void ajouteretaffecterProductACart(Cart cart, int productId);
	public void ajouteretaffecterUserACart(Cart cart, int userId);
	public void addItem(Product p );
	public Integer addProduct(Integer Productid,Integer quantity,Integer iduser);
	//public Cart fndByUserAndProduct(User user , Product p);
	public List<Cart>listcartitems(User user);
	//public float updateQuantity(Integer qte,Integer productid,User user);
}
