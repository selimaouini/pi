package tn.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
