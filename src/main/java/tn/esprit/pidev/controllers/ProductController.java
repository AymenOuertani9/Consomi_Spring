package tn.esprit.pidev.controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.services.IProductService;

@RestController
public class ProductController {
	 @Autowired
	 IProductService iProductService;
	//creating post mapping method that insert product into database
	 @PostMapping("/product/add-product")
	 @ResponseBody()
	 public int addProduct(@RequestBody Product p) {
		    iProductService.addProduct(p);
			return p.getIdProduct();
			
		}
	 
	//creating put mapping that updates the product detail  
	 @PutMapping("/product/update-product/{idProduct}")
	 @ResponseBody
		public ResponseEntity<String> updateProduct(
			@RequestBody Product product,@PathVariable("idProduct")int idProduct) {
		    iProductService.updateProduct(product,idProduct);
		    return new ResponseEntity<String>("Product updated successfully",HttpStatus.OK);
			
		}
	 
	  //creating a delete mapping that delete data from database
		@DeleteMapping("/product/delete-product/{idProduct}")
		@ResponseBody
		public ResponseEntity<String>  deleteProduct(
			@RequestBody Product product,@PathVariable("idProduct")int idProduct) {
			iProductService.deleteProduct(idProduct);
		    return new ResponseEntity<String>("Category deleted successfully",HttpStatus.ACCEPTED);
			
		}
		
		//creating a get mapping that retrieves all the product detail from the database   
		@GetMapping("/product/get-all-product")
		@ResponseBody
		public List<Product>  getAllProduct() {
			List<Product> product = new ArrayList<>();
			for(Product p : iProductService.getAllProducts()) {
				product.add(p);
			}
			return product;
		}
		
		//creating a get mapping that retrieves a specific product
		@GetMapping("/product/get-productbyId/{idp}")
		@ResponseBody
		public Product getProductById(@PathVariable("idp")int idp) {
			
			return iProductService.getProductById(idp);
		}
		
		//creating a get mapping that retrieves a specific product
		@GetMapping("/product/get-productbyCategory/{category}")
		@ResponseBody
		public List<Product> getProductById(@PathVariable("category")String categoryName) {
			
			return iProductService.getProductsByCategory(categoryName);
		}
		//creating get mapping that getProductByName   
        @GetMapping("/product/retrieve-Product-ByName/{name}")
		public Product findProductByName(@PathVariable String name) {
			Product product= iProductService.findProductByName(name);
			return product;
			}
        
        //Search product 
        @PutMapping("/product/searchProducts/{prod}/{cat}")
		@ResponseBody
		public List<Product>searchProducts(@PathVariable("prod")String prod,@PathVariable("cat")String cat) {
        	List<Product>products = iProductService.searchProducts(prod, cat);
        	return products;
        }
		//creating a get mapping that retrieves a specific productByBareCode
		@GetMapping("/product/get-productbyBarCode/{barCode}")
		@ResponseBody
		public Product getProductByBarCode(@PathVariable("barCode")String barCode) {
			
			return iProductService.findProductByBarCode(barCode);
		}
		//Verify 
		/*@GetMapping("/product/get-productbyBarCode/{barCode}")
		@ResponseBody
		public ResponseEntity<String> verifyProductByBarCode(@PathVariable("barCode")String barrecode) {
			if(iProductService.verifyProduct(barrecode)== true) 
			    return new ResponseEntity<String>("Product valid",HttpStatus.ACCEPTED);
			else 
				return new ResponseEntity<String>("Product invalid",HttpStatus.NOT_ACCEPTABLE);
		}
		*/
}
