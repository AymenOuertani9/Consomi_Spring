package tn.esprit.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.supplying;

@Repository
public interface ISupplyingRepository extends CrudRepository<supplying,Integer> {

}
