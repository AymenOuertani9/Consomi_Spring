package tn.esprit.pidev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.supplier;

@Repository
public interface ISupplierRepository extends CrudRepository<supplier,Integer> {

}
