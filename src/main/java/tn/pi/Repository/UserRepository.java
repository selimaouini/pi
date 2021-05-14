package tn.pi.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	//requet SQL
		@Query(value = "SELECT u FROM T_USER u WHERE u.dateN between :date1 and :date2" 
				, nativeQuery = true)
		List<User>retrieveUsersByDateSQL (@Param ("date1") Date date1, @Param("date2") Date date2 );
		
		
		//requet JPQL
		@Query("SELECT u FROM User u WHERE u.dateN between :date1 and :date2")
		List<User> retrieveUsersByDateJPQL (@Param ("date1") Date date1, @Param("date2") Date date2) ;
		
	  @Query("SELECT u FROM User u WHERE u.email=:email and u.password=:password")
		public User getUserByEmailAndPassword(@Param("email")String login,
		@Param("password")String password);

}
