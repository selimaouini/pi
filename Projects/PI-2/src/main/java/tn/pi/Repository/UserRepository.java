package tn.pi.Repository;

import org.springframework.stereotype.Repository;

import tn.pi.Entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String Username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail (String email); 
	
	
}
