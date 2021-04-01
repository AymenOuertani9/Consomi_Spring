package tn.esprit.pidev.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.LigneComand;


import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.ICartRepository;
import tn.esprit.pidev.repository.ILigneCommandeRepository;
import tn.esprit.pidev.repository.IProductRepository;
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
	private Map<Integer,LigneComand>lcs=new HashMap<Integer,LigneComand>();
	private Cart cart;
	@Transactional
	@Override
	public Boolean affecterProductAlc(int productId, int lcid,int cartId ) {
	LigneComand lc = lcrep.findById(lcid).get();
	Product pro = produitrep.findById(productId).get();
	Cart cart =cartrep.findById(cartId).get();
	lc.setProduit(pro);
	lc.setPrice(pro.getSellPrice());
	cart.setTotal(cart.getTotal()+(lc.getPrice()*lc.getQte()));
	lcrep.save(lc);
	return true;	
	}
	@Override
	public void affecterCartAlc(int cartId, int lcid) {
		LigneComand lc = lcrep.findById(lcid).get();
		Cart cart =cartrep.findById(cartId).get();
		lc.setCart(cart);
		lcrep.save(lc);
		
	}
	@Override
	public void affecterUserAlc(int userId, int lcid) {
		LigneComand lc = lcrep.findById(lcid).get();
		User u = userep.findById(userId).get();	
		lc.setUser(u);
		lcrep.save(lc);
	}
	@Override

	
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
	}
	@Override
	public LigneComand supprimerLignecommande(Product p) {
		if(p==null) {
			return null;}
		return lcs.remove(p.getIdProduct());
	}
	@Override
	public LigneComand modifierquantite(Product p, int qte) {
		if(p==null) {
			return null;}
		LigneComand lc =lcs.get(p.getIdProduct());
		if(lc==null) { return null;}
		lc.setQte(qte);
		return lc;
	}
	@Override
	public LigneComand getbyid(int lcid) {
		
		return lcrep.findById(lcid).get();
	}
	@Override
	public List<LigneComand> getall() {
		
		return lcrep.findAll();
	}
/*	
public void proposerproduit(int prodid, int lcid,String name) {
	Product p = produitrep.findById(prodid).get();
	if(this.affecterProductAlc(prodid, lcid)) {
		if(p.getCategory().getName()==name) {
			lcrep.propose();
			
		}
	}
}*/

	@Override
	public Product getproductfromcart(int lcid) {
		LigneComand lc = lcrep.findById(lcid).get();
		
	return	lc.getProduit();
	}
@Override
public List<Product> findTopFiveBestSeller() {
	
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
