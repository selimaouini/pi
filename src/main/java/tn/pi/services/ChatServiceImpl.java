package tn.pi.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.Repository.ChatRepository;
import tn.pi.Repository.UserRepository;
import tn.pi.entities.Chat;
import tn.pi.entities.User;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired 
	ChatRepository chatRepository; 
	
	@Autowired
	UserRepository userRepository;

	private static final Logger log = LogManager.getLogger(ChatServiceImpl.class);
	
	/******** JSF ********/
	@Override
	public long addOrUpdateChat(Chat chat, long senderId,long  receiverId) {
		chatRepository.save(chat);
		return chat.getIdch();
	}
	
	
	

	@Override
	public void deleteChatById(long idch) {
		chatRepository.deleteById(idch);

	}
		
	/******** Crud ********/
	
	@Override
	public Chat SendMsg(Chat chat) {
		chatRepository.save(chat);
		return chat;
	}

	@Override
	public void deleteMsg(String idch) {
		chatRepository.deleteById(Long.parseLong(idch));
	}

	@Override
	public List<Chat> retrieveAllMsgs() {
		List<Chat> msgs= (List<Chat>) chatRepository.findAll();
		for (Chat chat: msgs){
			log.info ("chat :" +chat);
				}
	return msgs; 	
	}
	
	 public void add(Chat c, long senderId, long receiverId) {
	        User sender=userRepository.findById(senderId).orElse(null);
	        User receiver=userRepository.findById(receiverId).orElse(null);
	        if (sender!=null && receiver!=null) {
	        //	c.setDateCreation(new Date());
	            c.setSender(sender);
	            c.setReceiver(receiver);
	            chatRepository.save(c);
	        }
	    }

	@Override
	public List<Chat> getConversation(long senderId, long receiverId) {
		   return chatRepository.getConversation(senderId, receiverId);
	}



}
