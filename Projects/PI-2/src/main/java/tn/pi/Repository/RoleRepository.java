package tn.pi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.pi.Entity.ERole;
import tn.pi.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Optional<Role> findByName(ERole name); 

}
