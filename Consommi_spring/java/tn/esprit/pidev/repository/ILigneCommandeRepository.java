package tn.esprit.pidev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.LigneComand;
import tn.esprit.pidev.entities.Product;

@Repository
public interface ILigneCommandeRepository extends JpaRepository<LigneComand, Integer>{
	
	@Query("select p from Product p "
		    + "join p.category c "
			+ "GROUP BY c.name")
	public List<Product> propose();
	 @Query(value = "select top 2 p.product_name from product p " +
		       
		        "group by p.id_product, p.product_name  " ,
		         nativeQuery = true)
		    public List<Product> findTopFiveBestSeller();

		@Query("select DISTINCT c from LigneComand c "
			    + "join c.user u "
				+ "where u.iduser=:userid")
	public List<LigneComand >getAllLigneCommandByUser(@Param("userid")int userId);
	//afficher les noms de produits , date de son ajout au panier avec la quantité ajouté pour chaque jour
	 @Query("select s.produit.productName, HOUR(s.date) , coalesce(avg(s.qte),0) from LigneComand s where YEAR(s.date)=:a and MONTH(s.date)=:m and DAY(s.date)=:j group by HOUR(s.date) order by s.produit.idProduct,HOUR(s.date) asc")
		public List<Object[]> getMoyenlignecmdJour(@Param("a")Integer a, @Param("m")Integer m, @Param("j")Integer j);
		//afficher les noms de produits , date de son ajout au panier avec la quantité ajouté pour chaque mois
		@Query("select s.produit.productName, DAY(s.date) , coalesce(avg(s.qte),0) from LigneComand s where YEAR(s.date)=:a and MONTH(s.date)=:m group by DAY(s.date) order by s.produit.idProduct,DAY(s.date) asc")
		public List<Object[]> getMoyenLigncommandMonth(@Param("a")Integer a, @Param("m")Integer m);
		//afficher les produits qui sont passé dans un cmd en affichant la date de cmd de chaque  etat et la moyenne de  total final pour chaque mois 
		@Query("select s.produit.productName, DAY(s.cart.command.dateSend) , coalesce(avg(s.cart.command.bill.totalfinal),0) from LigneComand s where YEAR(s.cart.command.dateSend)=:a and MONTH(s.cart.command.dateSend)=:m and s.cart.command.etat=:ORDERED group by DAY(s.cart.command.dateSend) order by s.produit.idProduct,DAY(s.cart.command.dateSend) asc")
		public List<Object[]> getMoyencommandMonth(@Param("a")Integer a, @Param("m")Integer m,  @Param("ORDERED")Etat etat);
		//afficher les moyenn de commande passés et la date de creation par année
		@Query("select MONTH(s.cart.command.dateSend) , coalesce(avg(s.cart.command.bill.totalfinal),0) from LigneComand s where s.cart.command.idcommand=:p and YEAR(s.cart.command.dateSend)=:a group by MONTH(s.cart.command.dateSend)")
		public List<Object[]> getMoyencommandyear(@Param("p") int idcommand, @Param("a")Integer a);
		
}