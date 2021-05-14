package tn.pi.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Cart;
import tn.pi.entities.Command;
import tn.pi.entities.Etat;
import tn.pi.entities.LigneComand;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;

@Repository
public interface ILigneCommandeRepository extends CrudRepository<LigneComand, Integer>{
	
	 @Query("select DISTINCT c from LigneComand c "
			    + "join c.user u "
				+ "where u.idUser=:userid")
	public List<LigneComand >getAllLigneCommandByUser(@Param("userid")int userId);

	
	//afficher les noms de produits , date de son ajout au panier avec la quantité ajouté pour chaque jour
	
	
	 @Query("select sum(c.price*c.qte) from LigneComand c where c.cart=:x ")
		public long sum(@Param("x") Cart cart);
	 
	 @Query("select count(c.idlc) from LigneComand c where c.cart=:x ")
		public int  count(@Param("x") Cart cart);
	 
	 
		
}
	
		
