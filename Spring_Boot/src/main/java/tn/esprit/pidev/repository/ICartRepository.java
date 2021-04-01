package tn.esprit.pidev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Cart;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.User;


@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>{
	

	@Query("select c from Cart c join c.user u where u.iduser=:userId")
	public List<Cart> getcartByIduser(@Param("userId")int userId);
	public Cart findByUser(User user);
	//public Cart findByUserAndProduct( User user,Product product);
	/*@Query("update Cart c "+"join Product p"+" set c.qte =?1 where  p.idProduct=?2 "+ "And c.user.iduser=?3")
	@Modifying
	public void updateQuantity(Integer qte,Integer productid,Integer userid);*/
	@Query("SELECT SUM(lc.price*lc.qte) FROM LigneComand lc "
			+ "join lc.cart c "
			+ "where c.idcart=:cartId")
	
	public double gettotalcart(@Param("cartId")int cartId);
	
}
