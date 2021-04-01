package tn.esprit.pidev.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.Product;

@Repository
public interface ILigneCommandeRepository extends JpaRepository<LigneComand, Integer>{
	
	@Query("select p from LigneComand c "
			 + "join c.produit p "
		    + "join p.category ca "
			+ "GROUP BY ca.name")
	public List<Object[]> propose();
	 @Query(value =" SELECT * "
	 		+ "	 FROM product p INNER  JOIN ligne_comand c ON p.id_product=c.produit_id_product " 
		      
		        + "	 ORDER BY (c.qte) DESC "
		        + "	 limit 5"
		        , nativeQuery = true)
	
	
		    public List<LigneComand > findTopFiveBestSeller();

		@Query("select DISTINCT c from LigneComand c "
				+ "join c.cart ca "
				+ "join ca.user u "
				+ "where u.iduser=:userid")
	public List<LigneComand >getAllLigneCommandByUser(@Param("userid")int userId);
	//afficher les noms de produits , date de son ajout au panier avec la quantité ajouté pour chaque jour
	 @Query("select s.produit.productName, HOUR(s.date) , coalesce(avg(s.qte),0) from LigneComand s where YEAR(s.date)=:a and MONTH(s.date)=:m and DAY(s.date)=:j group by HOUR(s.date) order by s.produit.idProduct,HOUR(s.date) asc")
		public List<Object[]> getMoyenlignecmdJour(@Param("a")Integer a, @Param("m")Integer m, @Param("j")Integer j);
		//afficher les noms de produits , date de son ajout au panier avec la quantité ajouté pour chaque mois
		@Query("select s.produit.productName, DAY(s.date) , coalesce(avg(s.qte),0) from LigneComand s where YEAR(s.date)=:a and MONTH(s.date)=:m group by DAY(s.date) order by s.produit.idProduct,DAY(s.date) asc")
		public List<Object[]> getMoyenLigncommandMonth(@Param("a")Integer a, @Param("m")Integer m);
		//afficher les produits qui sont passé dans un cmd en affichant la date de cmd de chaque  etat et la moyenne de  total final pour chaque mois 
		@Query("select s.produit.productName, DAY(s.cart.command.dateSend) , coalesce(avg(s.cart.command.delivery.bill.totalfinal),0) from LigneComand s where YEAR(s.cart.command.dateSend)=:a and MONTH(s.cart.command.dateSend)=:m and s.cart.command.etat=:ORDERED group by DAY(s.cart.command.dateSend) order by s.produit.idProduct,DAY(s.cart.command.dateSend) asc")
		public List<Object[]> getMoyencommandMonth(@Param("a")Integer a, @Param("m")Integer m,  @Param("ORDERED")Etat etat);
		//afficher les moyenn de commande passés et la date de creation par année
		@Query("select MONTH(s.cart.command.dateSend) , coalesce(avg(s.cart.command.price),0) from LigneComand s where s.cart.command.idcommand=:p and YEAR(s.cart.command.dateSend)=:a group by MONTH(s.cart.command.dateSend)")
		public List<Object[]> getMoyencommandyear(@Param("p") int idcommand, @Param("a")Integer a);
		 @Modifying
		    @Transactional
		    @Query("DELETE FROM LigneComand c WHERE c.produit.idProduct =:produitid and c.cart.idcart=:idc")
		 public void deleteproductfromcart(@Param("produitid") int idp,@Param("idc") int idcart);
		
		 @Modifying
		    @Transactional
		    @Query("UPDATE  LigneComand c  SET c.produit.idProduct=:idp WHERE  c.cart.idcart=:idc")
		 public void updateproductfromcart(@Param("idp") int idp,@Param("idc") int idc);

			@Query("select c.produit.productName , c.produit.description , c.produit.sellPrice from LigneComand c "
					+ "join c.cart ca "
					
					+ "where ca.idcart=:idc")
		 public List<Object[]> getproductfromcart(@Param("idc") int cid) ;
		
}