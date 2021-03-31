package tn.esprit.pidev.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.pidev.entities.Category;
import tn.esprit.pidev.entities.User;

public interface ICategoryRepository extends CrudRepository<Category,Integer>{
	
	Category findCategoryByname(String name); 

}
