package tn.pi.Controllers;

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
public class ControllerChatImpl {
	@Autowired 
	ChatService chatService;
	
	private String message;
	long receiverId;
	long senderId;
	private List<Chat> chats;
	
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
