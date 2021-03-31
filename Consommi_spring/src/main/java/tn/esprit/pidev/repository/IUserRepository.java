package tn.esprit.pidev.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.entities.supplying;

public interface IUserRepository extends CrudRepository<User,Integer> {

}
