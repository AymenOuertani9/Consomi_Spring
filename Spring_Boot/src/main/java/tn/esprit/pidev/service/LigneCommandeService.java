package tn.esprit.pidev.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.EtatCart;
import tn.esprit.pidev.entities.LigneComand;


import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Stock;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.ICartRepository;
import tn.esprit.pidev.repository.ILigneCommandeRepository;
import tn.esprit.pidev.repository.IProductRepository;
import tn.esprit.pidev.repository.IStockRepository;
import tn.esprit.pidev.repository.IUserRepository;

@Service
public class LigneCommandeService implements ILigneCommandeService{
	@Autowired
	ILigneCommandeRepository lcrep;
	@Autowired
	ICartRepository cartrep;
	@Autowired
	IProductRepository produitrep;
	@Autowired
	IUserRepository userep;
	@Autowired
	IStockRepository storep;
	@Transactional
	@Override
	public String affecterProductAlc(int productId,int cartId,int quantity ) {
		
		LigneComand lc = new LigneComand();
		Product pro = produitrep.findById(productId).get();
		Cart cart =cartrep.findById(cartId).get();
		Stock s =storep.findByproducts(pro);
		if(quantity<=s.getQuantity()) {
			double tot1=cart.getSubtotal();
			//double tot2=(lc.getPrice()*quantity);
		
		//if (!ObjectUtils.isEmpty(lc) && !ObjectUtils.isEmpty(pro)) {
		lc.setProduit(pro);
		lc.setPrice(pro.getSellPrice());
		double tot =tot1+(lc.getPrice()*quantity);
		lc.setQte(quantity);
		lc.setCart(cart);
		lc.setDate(new Date());
		List<User>users=new ArrayList<>();
		//users.add(cart.getUser());
		//if(quantity<=cart.getCommand().getStock().getQuantity()) {
		
	//	for(User u:users) {
			
			cart.setSubtotal(tot);
			cart.setEtatcart(EtatCart.abandonedbasket);

		//}
		cartrep.save(cart);
		lcrep.save(lc);
		
		return "you added"+" "+quantity+" "+"of product"+" "+pro.getProductName()+" "+"in the cart"+" "+cart.getIdcart()+" "+"and the total is"+" "+tot;
		}
		else {
			return "Sorry this quantity is not available at the moment you can order only"+" "+s.getQuantity()+" "+"of"+" "+pro.getProductName();
		}
	//}
		}
	//supprimer produit de panier 
	@Override
	public String  deletelcbyidproduct(int idproduit , int idcart,int lcid) {
		Product pro = produitrep.findById(idproduit).get();
		Cart cart =cartrep.findById(idcart).get();
		LigneComand lc = lcrep.findById(lcid).get();
		lcrep.deleteproductfromcart(idproduit,idcart);
		double tot =cart.getSubtotal()-(lc.getQte()*lc.getPrice());
		cart.setSubtotal(tot);
		cartrep.save(cart);
		return "the product is deleted from the cart and the total is:"+" " +tot;
	}

	//modifier produit de panier
	@Override
	public String updateproductfromcart(int lcid , int productId ,int quantity) {
		LigneComand lc =lcrep.findById(lcid).get();
		Product pro = produitrep.findById(productId).get();
		// Cart cart =cartrep.findById(idcart).get();
		double tot1 =lc.getCart().getSubtotal()-(lc.getQte()*lc.getPrice());
		
		lc.setProduit(pro);
		lc.setPrice(pro.getSellPrice());
		lc.setQte(quantity);
		double tot =tot1+(pro.getSellPrice()*quantity);
		lcrep.save(lc);
		
		
		lc.getCart().setSubtotal(tot);
		cartrep.save(lc.getCart());
		return "the product is modified successfully and the total is:"+" " +tot;
	}

	public Boolean updateqte(int qte,int lcid) {
		LigneComand lc = lcrep.findById(lcid).get();
		lc.setQte(qte);
		return true;
	}
	//update qte
	@Override
	public String updateQuantity(int lcid,Integer newqte) {
		LigneComand lc = lcrep.findById(lcid).get();
		int qte =lc.getQte();
		//Cart cart = cartrep.findById(cartid).get();
		//double subtotal =cart.getTotal()*qte+cart.getTotal();
		double tot =(lc.getPrice()*newqte+lc.getCart().getSubtotal()-lc.getPrice()*qte);
		if(this.updateqte(newqte, lcid)) {
			
			lc.getCart().setSubtotal(tot);
			cartrep.save(lc.getCart());

		}

		return  "you change a quantity from "+" "+qte+" "+"to"+" "+"so yor total be come :"+" "+tot;
	}

	@Override
	public String supprimerLignecommande(int idlc) {
		LigneComand lc = lcrep.findById(idlc).get();
		lcrep.delete(lc);
		double tot =(lc.getCart().getSubtotal())-(lc.getPrice()*lc.getQte());
		lc.getCart().setSubtotal(tot);
		return "your command line is deleted successfully and your total become "+tot;
	}

	@Override
	public LigneComand getbyid(int lcid) {

		return lcrep.findById(lcid).get();
	}
	@Override
	public List<LigneComand> getall() {

		return lcrep.findAll();
	}
	@Override		
public List<Object[]> proposerproduit() {
	
		return	lcrep.propose();

		}
	
	@Override
	public List<Object[]> getproductfromcart(int cid) {

		return	lcrep.getproductfromcart(cid);
	}
	@Override
	public List<LigneComand > findTopFiveBestSeller() {

		return lcrep.findTopFiveBestSeller();
	}
	@Override
	public List<Object[]> getMoyenlignecmdJour(Integer a, Integer m, Integer j) {

		return lcrep.getMoyenlignecmdJour(a, m, j);
	}
	@Override
	public List<Object[]> getMoyenLigncommandMonth(Integer a, Integer m) {

		return lcrep.getMoyenLigncommandMonth(a, m);
	}
	@Override
	public List<Object[]> getMoyencommandMonth(Integer a, Integer m,Etat etat) {

		return lcrep.getMoyencommandMonth(a, m , etat);
	}
	@Override
	public List<Object[]> getMoyencommandyear(int idcommand, Integer a) {

		return lcrep.getMoyencommandyear(idcommand, a);
	}
	@Override
	public List<LigneComand> findLigneCommandByUser(int userid) {

		return lcrep.getAllLigneCommandByUser(userid);
	}


}
/*	@Override
public void affecterCartAlc(int cartId, int lcid) {
	LigneComand lc = lcrep.findById(lcid).get();
	Cart cart =cartrep.findById(cartId).get();
	lc.setCart(cart);
	lcrep.save(lc);

}*/
/*	@Override
public void affecterUserAlc(int cartId, int lcid) {
	LigneComand lc = lcrep.findById(lcid).get();
	Cart cart =cartrep.findById(cartId).get();
	lc.getCart().setUser(cart.getUser());
	lcrep.save(lc);
}*/

/*	@Override


public void addProduct(Product p,int quantity) {
	Map<Integer,LigneComand> items = new HashMap<Integer,LigneComand>();
	LigneComand lc =items.get(p.getIdProduct());
	items.get(p.getIdProduct());
	if(lc==null) {
		LigneComand art = new LigneComand();
		art.setProduit(p);
		art.setQte(quantity);
		art.setPrice(p.getSellPrice());
		items.put(p.getIdProduct(), art);
		}

else {
	lc.setQte(lc.getQte()+quantity);
}
	lcrep.save(lc);

}
@Override
public LigneComand ajouterLignecommande(Product p) {
	if(p==null) {
	return null;}
	LigneComand lc =lcs.get(p.getIdProduct());
	if(lc!=null) {
		Integer qte =lc.getQte();
		lc.setQte(qte);
		lcs.put(p.getIdProduct(), lc);
	}else {
		LigneComand l = new LigneComand();
		l.setCart(cart);
		l.setQte(0);
		l.setPrice(p.getSellPrice());
		l.setProduit(p);
		lcs.put(p.getIdProduct(), l);
		return l;
	}
	return null;
}*/
/*@Override
public LigneComand modifierquantite(Product p, int qte) {
	if(p==null) {
		return null;}
	LigneComand lc =lcs.get(p.getIdProduct());
	if(lc==null) { return null;}
	lc.setQte(qte);
	return lc;
}*/