package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.ProgrammeFidelité;

@Repository
public interface IProgramfideliteRepository extends JpaRepository<ProgrammeFidelité, Integer>{

}
