package tn.esprit.pidev.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Participation;
@Repository
public interface IParticipationRepository extends CrudRepository<Participation, Integer> {

}
