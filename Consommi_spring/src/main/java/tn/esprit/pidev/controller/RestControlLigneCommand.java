package tn.esprit.pidev.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.service.ILigneCommandeService;

@RestController
public class RestControlLigneCommand {
	@Autowired
	ILigneCommandeService lcserv;

	//http://localhost:8081/SpringMVC/servlet/affecterProductAlc/1/1/1
	@PutMapping(value = "/affecterProductAlc/{idproduit}/{idlc}/{idcart}") 
	public void affecterProductAlc(@PathVariable("idproduit") int productId,@PathVariable("idlc") int lcid,@PathVariable("idcart")int cartId) {
		lcserv.affecterProductAlc(productId, lcid ,cartId);
	}

	//http://localhost:8081/SpringMVC/servlet/affecterCartAlc/1/1
	@PutMapping(value = "/affecterCartAlc/{idcart}/{idlc}") 

	public void affecterCartAlc(@PathVariable("idcart") int cartId,@PathVariable("idlc") int lcid) {

		lcserv.affecterCartAlc(cartId, lcid);	
	}


	//http://localhost:8081/SpringMVC/servlet/affecterUserAlc/1/1
	@PutMapping(value = "/affecterUserAlc/{idu}/{idlc}") 

	public void affecterUserAlc(@PathVariable("idu") int userId,@PathVariable("idlc") int lcid) {
		lcserv.affecterUserAlc(userId, lcid);	
	}

	//http://localhost:8081/SpringMVC/servlet/addProduct/1
	@PostMapping(value = "/addProduct/{qte}") 	
	public void addProduct(@RequestBody Product p,@PathVariable("qte") int quantity) {
		lcserv.addProduct(p, quantity);
	}

	//http://localhost:8081/SpringMVC/servlet/ajouterLignecommande
	@PostMapping(value = "/ajouterLignecommande") 	
	public LigneComand ajouterLignecommande(@RequestBody Product p) {
		return lcserv.ajouterLignecommande(p);
	}

	//http://localhost:8081/SpringMVC/servlet/supprimerLignecommande
	@PostMapping(value = "/supprimerLignecommande") 	

	public LigneComand supprimerLignecommande(@RequestBody Product p) {
		return lcserv.supprimerLignecommande(p);
	}

	//http://localhost:8081/SpringMVC/servlet/modifierquantite/{qte}
	@PutMapping(value = "/modifierquantite/{qte}") 
	public LigneComand modifierquantite(@RequestBody Product p,@PathVariable("qte") int qte) {
		return lcserv.modifierquantite(p, qte);
	}


	//http://localhost:8081/SpringMVC/servlet/getbyid/{idlc}
	@GetMapping(value = "/getbyid/{idlc}") 
	public LigneComand getbyid(@PathVariable("idlc") int lcid) {
		return lcserv.getbyid(lcid);
	}
	//http://localhost:8081/SpringMVC/servlet/getall
	@GetMapping(value = "/getall") 	

	public List<LigneComand> getall() {
		return lcserv.getall();
	}
/*
	//http://localhost:8081/SpringMVC/servlet/proposerproduit/{idprod}/{idlc}/{nom}
	@GetMapping(value = "/proposerproduit/{idprod}/{idlc}/{nom}") 	
	public void proposerproduit(@PathVariable("idprod") int prodid,@PathVariable("idlc") int lcid,@PathVariable("nom")String name) {
		lcserv.proposerproduit(prodid, lcid, name);
	}
*/
	//http://localhost:8081/SpringMVC/servlet/findTopFiveBestSeller
	@GetMapping(value = "/findTopFiveBestSeller") 	
	public List<Product> findTopFiveBestSeller() {
		return lcserv.findTopFiveBestSeller();
	}

	//http://localhost:8081/SpringMVC/servlet/getMoyenlignecmdJour/{a}/{m}/{j}
	@GetMapping(value = "/getMoyenlignecmdJour/{a}/{m}/{j}") 
	public List<Object[]> getMoyenlignecmdJour(@PathVariable("a") Integer a,@PathVariable("m")  Integer m,@PathVariable("j") Integer j) {
		return lcserv.getMoyenlignecmdJour(a, m, j);
	}
	
	
	//http://localhost:8081/SpringMVC/servlet/getMoyenLigncommandMonth/{a}/{m}
		@GetMapping(value = "/getMoyenLigncommandMonth/{a}/{m}") 
	public List<Object[]> getMoyenLigncommandMonth(@PathVariable("a") Integer a,@PathVariable("m")  Integer m) {
		return lcserv.getMoyenLigncommandMonth(a, m);
	}
	
	//http://localhost:8081/SpringMVC/servlet/getMoyencommandMonth/{a}/{m}/{etat}
			@GetMapping(value = "/getMoyencommandMonth/{a}/{m}/{etat}") 
		public List<Object[]> getMoyencommandMonth(@PathVariable("a") Integer a,@PathVariable("m")  Integer m,@PathVariable("etat") Etat etat) {
			return lcserv.getMoyencommandMonth(a, m,etat);
		}
		
		//http://localhost:8081/SpringMVC/servlet/getMoyencommandyear/{b}/{a}
		@GetMapping(value = "/getMoyencommandyear/{b}/{a}") 
		public List<Object[]> getMoyencommandyear(@PathVariable("b") int idcommand,@PathVariable("a") Integer a) {
			return lcserv.getMoyencommandyear(idcommand, a);
		}
		
		//http://localhost:8081/SpringMVC/servlet/getproductfromcart/{a}
				@GetMapping(value = "/getproductfromcart/{a}") 
		public Product getproductfromcart(@PathVariable("a") int lcid) {
			return lcserv.getproductfromcart(lcid);
		}	
		
}