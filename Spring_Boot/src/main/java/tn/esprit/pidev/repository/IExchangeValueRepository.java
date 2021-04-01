package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.ExchangeValue;

@Repository
public interface IExchangeValueRepository extends JpaRepository<ExchangeValue, Integer>{
	@Query("select  c from ExchangeValue c "
		    
			+ "where c.from=:from and c.to=:to")
	ExchangeValue findByFromAndTo(@Param("from") String from,@Param("to") String to);

}
