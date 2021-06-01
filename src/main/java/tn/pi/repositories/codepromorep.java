package tn.pi.repositories;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Ads;
import tn.pi.entities.Codepromo;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;

@Repository
public interface codepromorep extends CrudRepository<Codepromo,Integer>{

	
	 @Query("select c from Codepromo c where c.codeprom=:codeprom")
	    public Codepromo getcode(@Param("codeprom")int codeprom);



}
