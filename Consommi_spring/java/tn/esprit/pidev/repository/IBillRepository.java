package tn.esprit.pidev.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.TypeFacture;


@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer>{
	@Query("select b from Bill b  "
			+ "join b.user u "
			+ "where u.iduser=:userId" )
	public List<Bill> getbillByIduser(@Param("userId")int userId);
	@Query("select b from Bill b  "
			+ "join b.user u "
			+ "where u.iduser=:userId" )
	public Bill getbillByuser(@Param("userId")int userId);
	@Query("select b from Bill b "
			+ "join b.command c "
			+ "where c.idcommand=:orderId")
	public List<Bill> getbillByIdorder(@Param("orderId")int orderId);
	@Query("select p from Bill p where p.numBill=:num")
	public Bill find(@Param("num")int numero);
	
	//The COALESCE() function returns the first non-null value in a list
	@Query("select coalesce(sum(p.totalfinal),0) from Bill p where p.user=null ")
	public Double prixAchatsProduits();
	@Query("select coalesce(sum(p.totalfinal),0) from Bill p where p.user=null and p.datebill between :d1 and :d2")
	public Double prixAchatsProduitsbetwend1andd2(@Param("d1")Date d1, @Param("d2")Date d2);
	//les nbrs de factures 
	@Query("select count(p) from Bill p ")
	public long count();
	@Query("SELECT SUM(c.AmountCommand) FROM Command c "
			+ "join c.user u "
			+ "where u.iduser=:userId")
	
	public double gettotalbill(@Param("userId")int userId);
	@Query("select DISTINCT b from Bill b where b.datebill between :d1 and :d2")
	public List<Bill> getallbillbetwendate( @Param("d1")Date d1, @Param("d2")Date d2); 
	@Query("select DISTINCT b from Bill b where b.datereglement=:dreglmt")
	public List<Bill> findByDatereglement(@Param("dreglmt") Date datereglmt);
	@Query("select DISTINCT b from Bill b where b.datebill=:dbill")
	public List<Bill> findByDatebill(@Param("dbill") Date datebill);
	public List<Bill> findByTypeofbill(TypeFacture typeofbill);
	@Query("select DISTINCT b from Bill b where b.totalfinal >= 1000")
	public List<Bill> getBillBytotalfinalsup();
	//la moyenne de facture par jour 
	@Query("select HOUR(s.datebill) , coalesce(avg(s.totalfinal),0) from Bill s where s.command.idcommand=:p and YEAR(s.datebill)=:a and MONTH(s.datebill)=:m and DAY(s.datebill)=:j group by HOUR(s.datebill)")
	public List<Object[]> getMoyenBillJour(@Param("p") int idcommand,@Param("a")Integer a, @Param("m")Integer m, @Param("j")Integer j);
	
	//la moyenne de facture par mois
	@Query("select DAY(s.datebill) , coalesce(avg(s.totalfinal),0) from Bill s where s.command.idcommand=:p and YEAR(s.datebill)=:a and MONTH(s.datebill)=:m group by DAY(s.datebill)")
	public List<Object[]> getMoyenBillMonth(@Param("p") int idcommand, @Param("a")Integer a, @Param("m")Integer m); 
	//la moyenne de facture par mois
	@Query("select MONTH(s.datebill) , coalesce(avg(s.totalfinal),0) from Bill s where s.command.idcommand=:p and YEAR(s.datebill)=:a group by MONTH(s.datebill)")
	public List<Object[]> getMoyenBillyear(@Param("p") int idcommand, @Param("a")Integer a);
	
	
}
