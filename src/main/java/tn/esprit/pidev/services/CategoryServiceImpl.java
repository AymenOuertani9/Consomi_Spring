package tn.esprit.pidev.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entities.Category;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.repositories.ICategoryRepository;
import tn.esprit.pidev.repositories.IProductRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private ICategoryRepository iCategoryRepository;
	@Autowired
	private IProductRepository iProductRepository;
	/**********************Creating add method that insert category into database***************/
    @Override
	public int addCategory(Category c) {
		iCategoryRepository.save(c);
		 return c.getIdCategory();
	}
    /*******************Creating deleting method that remove category by id  from database*********/
	@Override
	public void deleteCategory(int idCategory) {
		iCategoryRepository.deleteById(idCategory);
		
	}
	/****************Creating update method that upgrade category from database*****************/
	@Override
	public void updateCategory(Category c, int idCategory) {
		iCategoryRepository.updateCateogry(c.getName(),idCategory);
		
	}
	/***************Creating getAll method that retrieve all category from database **************/
	@Override
	public List<Category> getAllCategories() {
		return (List<Category>)iCategoryRepository.findAll();
	}
	 /**************Creating getByid method that retrieve category detail from database************/
	@Override
	public Category findCategoryById(int id) {
		
		return iCategoryRepository.findById(id).get();
	}
	/**************Creating getByname method that retrieve category by name from database************/
	@Override
	public Category findCategoryByName(String name) {
		return iCategoryRepository.findCategoryByName(name);
	}
	/************************** Creating affecterCategoryProduct method  **************************/
	@Override
	public void affecterCategoryProduct(int idp, int idc) {
		Category category = iCategoryRepository.findById(idc).get();
        Product product = iProductRepository.findById(idp).get();
		product.setCategory(category);
		iProductRepository.save(product);
	}
	
	
	
	
	
	

	
}


