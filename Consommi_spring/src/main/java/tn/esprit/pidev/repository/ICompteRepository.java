package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Compte;

@Repository
public interface ICompteRepository extends JpaRepository<Compte, Integer>{

}
