package tn.pi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Product;
import tn.pi.entities.Stock;

@Repository
public interface IStockRepository extends CrudRepository<Stock, Integer>{
	
	
	public Stock findByproducts(Product product);
	
	 @Query("select c from Stock c where c.Quantity=0")
	    public Stock getstockep();


}
