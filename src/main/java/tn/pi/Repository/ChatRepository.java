package tn.pi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.pi.entities.Chat;



public interface ChatRepository extends CrudRepository <Chat, Long> {
	@Query("select c from Chat c where (c.sender.id = :senderId and c.receiver.id = :receiverId) or (c.sender.id = :receiverId and c.receiver.id = :senderId) order by c.dateCreation")
    List<Chat> getConversation(@Param("senderId")long senderId, @Param("receiverId")long receiverId);

}
