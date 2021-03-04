package tn.esprit.pidev.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Jackpot;

@Repository
public interface IJackpotRepository extends CrudRepository<Jackpot, Integer> {

}
