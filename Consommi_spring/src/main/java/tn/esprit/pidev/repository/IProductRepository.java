package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

}
