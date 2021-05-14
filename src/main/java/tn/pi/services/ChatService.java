package tn.pi.services;

import java.util.List;

import tn.pi.entities.Chat;



public interface ChatService {
	/******** JSF ********/
	public long addOrUpdateChat(Chat chat, long senderId, long receiverId);

	void deleteChatById(long idch);

	/******** Crud ********/
	List<Chat> getConversation(long senderId, long receiverId);
	List<Chat> retrieveAllMsgs();
	Chat SendMsg(Chat Chat);
	void add(Chat c, long senderId, long receiverId);
	void deleteMsg(String idch);

}
