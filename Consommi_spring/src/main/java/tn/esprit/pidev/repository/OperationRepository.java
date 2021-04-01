package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer>{
	
}
