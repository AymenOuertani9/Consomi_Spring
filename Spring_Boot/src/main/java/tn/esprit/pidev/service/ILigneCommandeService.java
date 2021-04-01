package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.Product;

public interface ILigneCommandeService {
	public String   affecterProductAlc(int productId,int cartId ,int quantity ) ;
	public String updateQuantity(int lcid,Integer newqte);
	public String  deletelcbyidproduct(int idproduit , int idcart ,int lcid);
	public String updateproductfromcart(int lcid  ,int productId ,int quantity);
	public LigneComand getbyid(int lcid);
	public List<LigneComand>getall();
	public String supprimerLignecommande(int idlc);
	public List<LigneComand > findTopFiveBestSeller();
	public List<Object[]> getMoyenlignecmdJour(Integer a,Integer m,Integer j);
	public List<Object[]> getMoyenLigncommandMonth(Integer a,Integer m);
	public List<Object[]> getMoyencommandMonth(Integer a,Integer m ,Etat etat);
	public List<Object[]> getMoyencommandyear(int idcommand,Integer a);
	public List<Object[]> getproductfromcart(int lcid);
	public List<LigneComand> findLigneCommandByUser(int userid);
	
	
	
	//public void affecterCartAlc(int cartId, int lcid) ;
		//public void affecterUserAlc(int userId, int lcid) ;
		//Integer addProduct(Integer idProduct, Integer qte, Integer iduser);
		//public void addProduct(Product p, int quantity);
		//public LigneComand ajouterLignecommande(Product p);
	//public LigneComand modifierquantite(Product p,int qte);
	public List<Object[]> proposerproduit();
}
