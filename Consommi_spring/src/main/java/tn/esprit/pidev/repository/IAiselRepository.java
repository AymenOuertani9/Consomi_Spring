package tn.esprit.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Radius;

@Repository
public interface IAiselRepository extends CrudRepository<Radius, Integer> {

}
