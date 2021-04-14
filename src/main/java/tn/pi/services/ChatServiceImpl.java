package tn.pi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.Repository.ChatRepository;
import tn.pi.Repository.CommentRepository;
import tn.pi.entities.Chat;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired 
	ChatRepository chatRepository; 

	@Override
	public Chat SendMsg(Chat chat) {
		chatRepository.save(chat);
		return chat;
	}

}
