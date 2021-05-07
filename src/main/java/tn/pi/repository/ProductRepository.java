package tn.pi.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Category;
import tn.pi.entities.Product;
//import tn.pi.entities.Stock;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
 
	Product findByproductName(String Name);
	List<Product> findBycategory(Category category);
	
	/**********************************Find product ByName******************************/
	@Query("SELECT product FROM Product product WHERE product.productName = :productName")
	public Product findProductByName(@Param("productName")String productName);
	
	/**********************************Find product ByIdCAtegory******************************/
	@Query("select DISTINCT c from Product c join Category u where u.idCategory=:id")
	//@Query("SELECT product FROM Product product JOIN Category cat WHERE product.category.idCategory  = :id")
	public List<Product> findProductByIdCategory(@Param("id")int id);
	/**********************************Find product ByCategory***************************/
	@Query("SELECT prod FROM Product prod JOIN Category cat ON prod.category.name = :name")
	public List<Product> filterProductByCategory(@Param("name")String category);
	
	/**********************************Find product Bybarcode***************************/
	@Query("SELECT product FROM Product product WHERE product.barCode = :barCode")
	public Product findProductByBarCode(@Param("barCode")String barCode);
    /**********************************Find product Bymost view ***************************/
	@Modifying
	@Transactional
	@Query("UPDATE Product p   SET p.mostViewed = :view+1 WHERE p.id =:id ")
	public int updateViewCountProduct(@Param("view")int view,@Param("id")int id);

}
