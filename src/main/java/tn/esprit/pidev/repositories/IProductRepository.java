package tn.esprit.pidev.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entities.Product;
@Repository
public interface IProductRepository extends CrudRepository<Product, Integer>{

	/**********************************Find product ByName******************************/
	@Query("SELECT product FROM Product product WHERE product.productName = :productName")
	public Product findProductByName(@Param("productName")String productName);
	
	/**********************************Find product ByCategory***************************/
	@Query("SELECT prod FROM Product prod JOIN Category cat ON prod.category.name = :name")
	public List<Product> filterProductByCategory(@Param("name")String category);
	
	/**********************************Find product ByCategory***************************/
	@Query("SELECT product FROM Product product WHERE product.barCode = :barCode")
	public Product findProductByBarCode(@Param("barCode")String barCode);
	
}
