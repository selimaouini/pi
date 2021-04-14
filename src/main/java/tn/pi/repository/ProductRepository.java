package tn.pi.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Category;
import tn.pi.entities.Product;
//import tn.pi.entities.Stock;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
 
	Product findByproductName(String Name);
	List<Product> findBycategory(Category category);
	
}
