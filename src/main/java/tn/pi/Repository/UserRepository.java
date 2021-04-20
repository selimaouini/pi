package tn.pi.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.pi.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {

}
