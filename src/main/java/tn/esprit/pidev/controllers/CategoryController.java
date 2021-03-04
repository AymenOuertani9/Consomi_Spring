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
import tn.esprit.pidev.entities.Category;
import tn.esprit.pidev.services.ICategoryService;

@RestController
public class CategoryController {
    @Autowired
	ICategoryService iCategoryService;
   
    //creating a post mapping that add category in database
    @PostMapping("/category/add-category")
	@ResponseBody
	public int  addCategory(@RequestBody Category c) {
    	iCategoryService.addCategory(c);
		return c.getIdCategory();
		
	}
    //creating a put  mapping that upgrade category
	@PutMapping("/category/update-category/{idCategory}")
	@ResponseBody
	public ResponseEntity<String> updateCategory(
		@RequestBody Category category,@PathVariable("idCategory")int idCategory) {
		iCategoryService.updateCategory(category,idCategory);
	    return new ResponseEntity<String>("Category updated successfully",HttpStatus.OK);
		
	}
	//creating a delete mapping that delete category from database
	@DeleteMapping("/category/delete-category/{idCategory}")
	@ResponseBody
	public ResponseEntity<String>  deleteCategory(
		@RequestBody Category category,@PathVariable("idCategory")int idCategory) {
		iCategoryService.deleteCategory(idCategory);
	    return new ResponseEntity<String>("Category deleted successfully",HttpStatus.ACCEPTED);
		
	}
	//creating a get mapping that retrieves all categories from database.
	@GetMapping("/category/get-all-category")
	@ResponseBody
	public List<Category>  getAllCategories() {
		List<Category> categories = new ArrayList<>();
		for(Category c : iCategoryService.getAllCategories()) {
			categories.add(c);
			
		}
		
		return categories;
	}
	
	 //creating a get mapping that retrieves all categories from database.
	 @GetMapping("/category/find-category-byid/{id}")
	 @ResponseBody
		public Category findCategoryById(@PathVariable("id")int id) {
			return iCategoryService.findCategoryById(id);
		}
		
	  //creating a get mapping that retrieves all categories from database.
	 @GetMapping("/category/find-category-byname/{name}")
	 @ResponseBody
		public Category findCategoryByName(@PathVariable("name")String name) {
			return iCategoryService.findCategoryByName(name);
		}
	//creating a put mapping that affected category product from database.
	@PutMapping("/category/affecter-category-product/{idp}/{idc}")
	@ResponseBody
		public String affectCategoryProduct(@PathVariable("idp")int idp, @PathVariable("idc")int idc) {
		iCategoryService.affecterCategoryProduct(idp, idc);
		return "Category affected to Product successfully!!";
	}
	
}
