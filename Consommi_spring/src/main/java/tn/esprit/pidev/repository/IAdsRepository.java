package tn.esprit.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Ads;

@Repository
public interface IAdsRepository extends CrudRepository<Ads,Integer> {

}
