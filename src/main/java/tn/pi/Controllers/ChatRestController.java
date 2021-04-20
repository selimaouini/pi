package tn.pi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.Repository.ChatRepository;
import tn.pi.entities.Chat;
import tn.pi.entities.Comment;
import tn.pi.services.ChatService;


@RestController
public class ChatRestController {
	@Autowired 
	ChatService chatService; 
	
	// http://localhost:8081/SpringMVC/servlet/chat/add-chat
	@PostMapping("/chat/add-chat/{user-id}")
	@ResponseBody
	public Chat addChat(@RequestBody Chat ch) {
		Chat chat = chatService.SendMsg(ch);
	return chat;
	}

}