package tn.esprit.pidev.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Ads;

@Repository
public interface IAdsRepository extends CrudRepository<Ads,Integer> {
	
	List<Ads> getAdsByStartDate(Date SDate);
	List<Ads> getAdsByFinishDate(Date FDate);

}
