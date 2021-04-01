package tn.esprit.pidev.service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.EtatCart;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.ICartRepository;
import tn.esprit.pidev.repository.ICommandRepository;
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
	@Autowired
	ICommandRepository comrep;
	@Override
	public List<Cart>getcartByIduser(int iduser) {

		return cartrep.getcartByIduser(iduser);
	}
	@Override
	public Cart getCartById(int cartId) {

		return cartrep.findById(cartId).orElse(null);
	}

	@Override
	public String affecterCartAUser(int userId, int cartId) {
		Cart c = cartrep.findById(cartId).get();
		User u = userep.findById(userId).get();
		c.setUser(u);
		cartrep.save(c);
		return "the user "+u.getFirstname()+"is asigned to the cart  "+c.getIdcart();

	}
	/*@Override
	public Cart enregistrerCart(Cart cart) {

		return cartrep.save(cart);
	}*/
	@Override
	public double getCartTotalById(int lcId,int cartId ) {
		LigneComand lc = lcrep.findById(lcId).get();
		Cart cart=cartrep.findById(cartId).get();

		double totalligne=lc.getQte()*(lc.getPrice());	
		double total=cart.getSubtotal();
		total=+totalligne;

		//cart.getCommand().setPrice(total);
	//	comrep.save(cart.getCommand());
		return total;}

	/*
	@Override
	public List<String> getAllCartProductsnames(int cartId) {
		return null;
	}*/
	/*	@Override
	public void mettreAjourProductByCartId(String name, int cartId,int productid) {

		}


	 */
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

	/*@Override
	public List<Product> getAllCartProducts(int cartId) {
	return null;	
	}*/
	@Override
	public void deleteCartById(int cartId) {
		Cart cart = cartrep.findById(cartId).get();
		cartrep.delete(cart);


	}

	@Transactional
	public String ajouteretaffecterUserACart(Cart cart, int userId) {
		User user =userep.findById(userId).get();

		cart.setUser(user);
		cart.setEtatcart(EtatCart.abandonedbasket);
		cartrep.save(cart);
		return "the cart is successfully assigned to the customer";


	}

	/*
	@Override
	public Cart fndByUserAndProduct(User user, Product p) {

		return null;
				//cartrep.findByUserAndProduct(user, p);
	}
	/*
	@Override
	public Cart enregistrerCart(Cart cart) {

		return cartrep.save(cart);
	}
	@Override
	public List<Cart> listcartitems(User user) {
		// TODO Auto-generated method stub
		return null;
	}





/*
@Override
public void viderpanier(int cartId) {
	// TODO Auto-generated method stub

}*/
	@Override
	public double getTotalcart(int cartId) {

		Cart cart = cartrep.findById(cartId).get();

		double total=cartrep.gettotalcart(cartId);
		cart.setSubtotal(total);    

		cartrep.save(cart);
		cart.getCommand().setPrice(total);
		comrep.save(cart.getCommand());
		return total;




	}
	@Override
	public List<Cart> listcartitems() {

		return cartrep.findAll();
	}

}


