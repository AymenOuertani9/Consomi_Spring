package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.Product;

public interface ILigneCommandeService {
	public Boolean affecterProductAlc(int productId, int lcid,int cartId ) ;
	public void affecterCartAlc(int cartId, int lcid) ;
	public void affecterUserAlc(int userId, int lcid) ;
	//Integer addProduct(Integer idProduct, Integer qte, Integer iduser);
	public void addProduct(Product p, int quantity);
	public LigneComand ajouterLignecommande(Product p);
	public LigneComand supprimerLignecommande(Product p);
	public LigneComand modifierquantite(Product p,int qte);
	public LigneComand getbyid(int lcid);
	public List<LigneComand>getall();
	//public void proposerproduit(int prodid, int lcid,String name);
	public List<Product> findTopFiveBestSeller();
	public List<Object[]> getMoyenlignecmdJour(Integer a,Integer m,Integer j);
	public List<Object[]> getMoyenLigncommandMonth(Integer a,Integer m);
	public List<Object[]> getMoyencommandMonth(Integer a,Integer m ,Etat etat);
	public List<Object[]> getMoyencommandyear(int idcommand,Integer a);
	public Product getproductfromcart(int lcid);
	public List<LigneComand> findLigneCommandByUser(int userid);
}
