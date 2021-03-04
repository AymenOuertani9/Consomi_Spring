package tn.esprit.pidev.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Promotion;
@Repository
public interface IPromotionRepository extends CrudRepository<Promotion, Integer>{

	/**********************************Return List Current Promotion***************************/
	@Query("SELECT p FROM Promotion p WHERE CURRENT_DATE() >= p.startDate and CURRENT_DATE()<= p.endDate")
	public List<Promotion>getCurrentPromotions();
}
