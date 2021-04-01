package tn.esprit.pidev.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Cart;

import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.service.ICartService;
import tn.esprit.pidev.service.IUserService;



@RestController
public class RestControlCart {
	@Autowired
	ICartService cartsev;
	@Autowired
	IUserService userserv;
/*	
	// URL : http://localhost:8081/SpringMVC/servlet/getcartByIduser/{id}
    @GetMapping(value = "/getcartByIduser/{id}")
    
    public List<Cart>getcartByIduser(@PathVariable("id")int iduser) {
    	//User user=userserv.getUserById(iduser);
		return cartsev.getcartByIduser(iduser);
	}
    
 // http://localhost:8081/SpringMVC/servlet/affecterProductACart/1/1
 	@PutMapping(value = "/affecterProductACart/{idproduit}/{idcart}") 
    public void affecterProductACart(@PathVariable("idproduit")int productId,@PathVariable("idcart") int cartId) {
    	
    cartsev.affecterProductACart(productId, cartId);	
    }
 	 // http://localhost:8081/SpringMVC/servlet/desaffecterProductDuCart/1/1
 	@PutMapping(value = "/desaffecterProductDuCart/{idproduit}/{idcart}") 
 	public void desaffecterProductDuCart(@PathVariable("idproduit")int productId,@PathVariable("idcart") int cartId) {
 		cartsev.desaffecterProductDuCart(productId, cartId);
 	}
 // http://localhost:8081/SpringMVC/servlet/enregistrerCart
 	
 	@PostMapping(value ="/enregistrerCart")
	 	public Cart enregistrerCart(@RequestBody Cart cart) {
 		cartsev.enregistrerCart(cart);
 		return cart;
 	}*/
 	
 // URL : http://localhost:8081/SpringMVC/servlet/getCartTotalById/{idlc}/{idcart}
    @GetMapping(value = "/getCartTotalById/{idlc}/{idcart}")
    public double getCartTotalById(@PathVariable("idlc") int lcId,@PathVariable("idcart") int cartId )  {
 		return cartsev.getCartTotalById(lcId ,cartId );
 	}
	
    // URL : http://localhost:8081/SpringMVC/servlet/deleteCartById/1
    @DeleteMapping("/deleteCartById/{idcart}") 
    public void deleteCartById(@PathVariable("idcart")int cartId) {
    	cartsev.deleteCartById(cartId);
    }
    /*
 // URL : http://localhost:8081/SpringMVC/servlet/getAllCartProductsnames/{idcart}
    @GetMapping(value = "/getAllCartProductsnames/{idcart}")
    public List<String> getAllCartProductsnames(@PathVariable("idcart")int cartId) {
    	return cartsev.getAllCartProductsnames(cartId);
    }
    
 // http://localhost:8081/SpringMVC/servlet/mettreAjourProductByCartId/1/1/
  	@PutMapping(value = "/mettreAjourProductByCartId/{idcart}/{idpro}/{nom}") 
    public void mettreAjourProductByCartId(@PathVariable("nom")String name,@PathVariable("idcart") int cartId,@PathVariable("idpro")int productid) {
  		cartsev.mettreAjourProductByCartId( name, cartId,productid);
  	}
  // http://localhost:8081/SpringMVC/servlet/addOrUpdateCart
  	@PostMapping("/addOrUpdateCart")
	
	
  	public int addOrUpdateCart(@RequestBody Cart cart) {
  		return cartsev.addOrUpdateCart(cart);
  	}
  	
  	
  	//http://localhost:8081/SpringMVC/servlet/affecterCartAUser/1/1
  	 	@PutMapping(value = "/affecterCartAUser/{iduser}/{idcart}") 
  	public void affecterCartAUser(@PathVariable("iduser")int userId,@PathVariable("idcart") int cartId) {
  		cartsev.affecterCartAUser(userId, cartId);
  	}
  	// URL : http://localhost:8081/SpringMVC/servlet/getAllCartProducts/{idcart}
  	    @GetMapping(value = "/getAllCartProducts/{idcart}")
  	 	public List<Product> getAllCartProducts(@PathVariable("idcart") int cartId){
  	 		return cartsev.getAllCartProducts(cartId);
  	 	}
  	// URL : http://localhost:8081/SpringMVC/servlet/viderpanier/1
  	    @DeleteMapping("/viderpanier/{idcart}")
  	  public void viderpanier(@PathVariable("idcart") int cartId) {
  		  cartsev.viderpanier(cartId);
  	  }
  	// http://localhost:8081/SpringMVC/servlet/ajouteretaffecterProductACart/4
  	  	@PostMapping("/ajouteretaffecterProductACart/{idprod}")
  	  public void ajouteretaffecterProductACart(@RequestBody Cart cart,@PathVariable("idprod") int productId) {
  	  		cartsev.ajouteretaffecterProductACart(cart, productId );
  	  	}
  	  	
  	// http://localhost:8081/SpringMVC/servlet/ajouteretaffecterUserACart/1
  	  	@PostMapping("/ajouteretaffecterUserACart/{iduser}")
  	  public void ajouteretaffecterUserACart(@RequestBody Cart cart,@PathVariable("iduser") int userId) {
  	  		cartsev.ajouteretaffecterUserACart(cart, userId);
  	  	}
  	// http://localhost:8081/SpringMVC/servlet/addItem
  	  	@PostMapping("/addItem")
  	  public void addItem(@RequestBody Product p) {
  		  cartsev.addItem(p);
  	  }
  	 /* 	
  	// http://localhost:8081/SpringMVC/servlet/addProduct/{idprod}/{qte}/{idu}
  	  	@PostMapping("/addProduct/{idprod}/{qte}/{idu}")
  	  public Integer addProduct(@PathVariable("idprod") Integer Productid,@PathVariable("qte") Integer quantity,@PathVariable("idu") Integer iduser) {
  		return cartsev.addProduct(Productid, quantity,iduser);
}
  	  	/*
  	  	
  	//http://localhost:8081/SpringMVC/servlet/updateQuantity/1/1
  	 	@PutMapping(value = "/updateQuantity/{qt}/{idprod}") 
  	  public float updateQuantity(@PathVariable("qt") Integer qte,@PathVariable("idprod") Integer productid,@RequestBody User user) {
  		  return cartsev.updateQuantity(qte, productid, user);
  	  }*/
    // URL : http://localhost:8081/SpringMVC/servlet/updateQuantity/{qt}/{idlc}/{idcrt}/{newqt}
    @PutMapping(value = "/updateQuantity/{qt}/{idlc}/{idcrt}/{newqt}")
    public String updateQuantity(@PathVariable("qt") Integer qte,@PathVariable("idlc") int lcid,@PathVariable("idcrt") int cartid,@PathVariable("newqt") Integer newqte) {
    	return cartsev.updateQuantity(qte, lcid, cartid,newqte);
    }
    
  //URL : http://localhost:8081/SpringMVC/servlet/getTotalcart/{idcart}/{idcom}/{iduser}
    @GetMapping(value = "/getTotalcart/{idc}")
    public double getTotalcart(@PathVariable("idc")int cartId) {
    	return cartsev.getTotalcart(cartId);
    }
}
