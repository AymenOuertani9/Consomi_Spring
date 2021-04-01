package tn.esprit.pidev.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Ads;
import tn.esprit.pidev.entities.AdsView;

@Repository
public interface IAdsViewRepository extends CrudRepository<AdsView,Integer> {
	
	AdsView getAdsViewByAds(Ads ads);

}
