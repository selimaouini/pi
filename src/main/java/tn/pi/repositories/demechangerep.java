package tn.pi.repositories;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Ads;
import tn.pi.entities.Codepromo;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.Demandechange;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;
import tn.pi.entities.catalog;

@Repository
public interface demechangerep extends CrudRepository<Demandechange,Integer>{

	@Query("select c FROM catalog c where (c.name=:wc) ")
	public catalog  getcatalogbyname(@Param ("wc") String name);


}
