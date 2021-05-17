package tn.pi.repositories;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Category;
//import tn.pi.entities.User;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

	Category findCategoryByname(String name); 
	/**********************************Update category ***************************/
	@Transactional
	@Modifying
	@Query("UPDATE Category  c SET c.name = :name WHERE c.id =:id")
	public void updateCategory(@Param("name")String name,@Param("id")int id);
	/**********************************Find category ByName***************************/
	@Query("SELECT cat from Category cat WHERE cat.name =:name")
	public Category findCategoryByName(@Param("name")String name);
	/**********************************Find product ByName***************************/
	@Query("SELECT cat from Category cat WHERE cat.name =:name")
	public Category findProductByName(@Param("name")String name);

}
