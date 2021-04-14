package tn.pi.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Category;
//import tn.pi.entities.User;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

	Category findCategoryByname(String name); 
}
