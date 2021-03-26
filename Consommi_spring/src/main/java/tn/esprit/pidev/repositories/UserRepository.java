package tn.esprit.pidev.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.pidev.entities.Contrat;
import tn.esprit.pidev.entities.UserConsomi;

@Repository
public interface UserRepository extends JpaRepository<UserConsomi, Integer> {
	//Optional<User> findByUserName(String userName);
     public UserConsomi findByUsername(String username);

     
     @Transactional
     @Modifying
     @Query("UPDATE UserConsomi a " +
             "SET a.active = TRUE WHERE a.username = ?1")
     public int activeUserConsomi(String username);
     
     
     
     @Query("select c.salary from Contrat c join c.user e where e.iduser=:employeId")
	    public float getSalaire(@Param("employeId")int employeId);
    
     
     @Query("Select "
 			+ "DISTINCT SUM(cont.salary) from Contrat cont ")
// 			+ "join cont.user emp "
// 			+ "where emp.iduser=:employeId")  
 			
     public Double getSalaires();
     
     
     @Query("Select "
  			+ "DISTINCT SUM(cont.carnetcarburant) from Delivery cont ")
			  
  			
      public Double getCarburant();



//     @Modifying
//     @Transactional
//     @Query("UPDATE UserConsomi e SET e.active=:TRUE where e.email= ?1")
//     public void ActiveUserConsomi(String email);

}
