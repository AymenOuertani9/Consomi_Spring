package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Delivery;

@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery, Integer>{

}
