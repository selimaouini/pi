package tn.pi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Cart;
import tn.pi.entities.LigneComand;
import tn.pi.entities.Product;
import tn.pi.entities.User;


@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>{


	 @Query("select DISTINCT c from Cart c "
			    + "join c.user u "
				+ "where u.idUser=:userid")
	public List<Cart>getpanierByUser(@Param("userid")int userId);
	
	@Query("SELECT SUM(lc.price*lc.qte) FROM LigneComand lc "
			+ "join lc.cart c "
			+ "where c.idcart=:cartId")
	
	public double gettotalcart(@Param("cartId")int cartId);
	
	
	
	
	
	
}
