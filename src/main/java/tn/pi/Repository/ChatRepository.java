package tn.pi.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.pi.entities.Chat;



public interface ChatRepository extends CrudRepository <Chat, Long> {

}
