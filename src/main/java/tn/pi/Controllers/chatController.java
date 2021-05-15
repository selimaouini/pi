package tn.pi.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.pi.entities.Chat;
import tn.pi.entities.Rating;
import tn.pi.services.ChatService;

@Scope(value = "session")
@Controller(value = "chatController")
@ELBeanName(value = "chatController")
@Join(path = "/chat", to = "/chat/sendMsg.jsf")
public class chatController {
	@Autowired 
	ChatService chatService;
	
	private String message;
	long receiverId;
	long senderId;
	private List<Chat> chats;
	
	
	
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public Chat addUser(@Payload Chat chat, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chat.getSender());
		return chat;
	}
	
	
	@MessageMapping("/chat.send")
	@SendTo("/chat/public")
	public Chat sendMessage(@Payload Chat chat) {
		return chat;
	}
	
	public void sendChat() {
		chatService.addOrUpdateChat(new Chat(), receiverId, receiverId);
		//	chatService.add(Chat c, receiverId, receiverId);
//			return navigateTo;
		}




		public List<Chat> getChats() {	
//			if (authenticatedUser==null || !loggedIn) return "/login.xhtml";
			chats = chatService. getConversation( senderId, receiverId);
			return chats;
//			return navigateTo;
		}

		public void removeChat(long idch) {
//			if (authenticatedUser==null || !loggedIn) return "/login.xhtml";
			chatService.deleteChatById(idch);
//			return navigateTo;
		}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}
	
	
}
