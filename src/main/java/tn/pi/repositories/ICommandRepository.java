 package tn.pi.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Cart;
import tn.pi.entities.Command;
import tn.pi.entities.Etat;
import tn.pi.entities.ModePayement;
import tn.pi.entities.Product;
import tn.pi.entities.User;
@Repository
public interface ICommandRepository extends JpaRepository<Command,Integer>{
	

	
	
	@Query("select Max(numcommand) from Command ")
	public int getMaxNumcommand();
	
	@Query("select Max(nb) from User ")
	public int getclient();
	
	@Query("select DISTINCT u from User u "
		 + "where u.nb=:nb")
	public User  bestuser(@Param("nb")int nb);
	
	@Query("select DISTINCT c from Command c "
			+ "join c.cart t "
		    + "where t.idcart=:cartid")
	public Command findCommandByCart(@Param("cartid")int cartid);
	
	@Query("select DISTINCT c from Command c "
		    + "join User u "
			+ "where c.user=:user")
public List<Command >getAllCommandByUser(@Param("user")User user);
	
	@Query("select c FROM Command c ORDER BY c.dateCreation DESC")
	public List<Command> findByOrderByOrderDatecreationDesc() ;
	
	@Query("select c FROM Command c  where c.dateCreation=:x")
	public List<Command> commandetoday(@Param("x") Date x) ;
	
	@Query("select count(c) from Command c where c.etat=:x ")
	public long count(@Param("x") Etat etat);
	@Query("select c FROM Command c where c.etat=:x ORDER BY c.dateCreation DESC")
	public List<Command> findByEtatOrderByDatecreationDesc(@Param("x") Etat etat) ;
	public List<Command >findByPayement(ModePayement payement);
	public Command findByDateCreation(Date datecreation);
	
	
	 @Query("select sum(c.AmountCommand) from Command c where c.dateCreation=:x ")
		public long sum(@Param("x") Date dateCreation);
	
	

	
	@Query("SELECT (c.subtotal) FROM Cart c "
			+ "join User u "
			+ "where u.idUser=:userId and c.idcart=:cartid")
	public double gettotalcommand(@Param("userId")int userId , @Param("cartid")int cartid);
	//@Query("select c FROM Command c where (c.dateCreation=:dc) order by c.dateSend desc")
	public List<Command> getCommandByDateCreation(Date datecreation); 

}