package tn.esprit.spring.repository.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User.Employe;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {
	
	Optional<Employe> findByUsername(String username);
	
@Query("SELECT e FROM Employe e WHERE e.email=:email and e.password=:password")
public Employe getEmployeByEmailAndPassword(@Param("email")String login,
@Param("password")String password);

boolean existsByUsername(String username);

Boolean existsByEmail(String email);

}