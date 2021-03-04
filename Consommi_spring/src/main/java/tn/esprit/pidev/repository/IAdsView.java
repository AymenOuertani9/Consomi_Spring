package tn.esprit.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.AdsView;

@Repository
public interface IAdsView extends CrudRepository<AdsView,Integer> {

}
