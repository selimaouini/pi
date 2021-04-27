package tn.pi.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.Repository.ChatRepository;
import tn.pi.entities.Chat;
import tn.pi.services.ChatService;


@RestController
public class ChatRestController {
	@Autowired 
	ChatService chatService; 
	@Autowired 	
	ChatRepository chatRepository;
	
	// http://localhost:8081/SpringMVC/servlet/chat/add-chat/{senderId}/{receiverId}
	@PostMapping("/chat/add-chat/{senderId}/{receiverId}")
	@ResponseBody
	public ResponseEntity <String> addChat(@RequestBody Chat c, @PathVariable("senderId")long senderId, @PathVariable("receiverId")long receiverId) {
	//  if (UserSession.hasId(senderId) && !c.getMessage().isEmpty())		
		chatService.add(c, senderId, receiverId);
		 return new ResponseEntity <String>("Message added !",HttpStatus.OK);
	}
	
	//http://localhost:8081/SpringMVC/servlet/chat/remove-msg/{chat-id}
     @DeleteMapping("/chat/remove-msg/{chat-id}")
     @ResponseBody
     public ResponseEntity <String> deleteMsg(@PathVariable("chat-id") String idch) {
       chatService.deleteMsg(idch);
  	 return new ResponseEntity <String>("Message deleted !",HttpStatus.OK);
            }

	// http://localhost:8081/SpringMVC/servlet/chat/retrieve-all-msgs
	@GetMapping("/chat/retrieve-all-msgs")
	@ResponseBody
	public List<Chat> getMsgs() {
	List<Chat> list = chatService.retrieveAllMsgs();
	return list;
	}


	    @GetMapping("/chat/{senderId}/{receiverId}")
	    @ResponseBody
	    public List<Chat> getConversation(@PathVariable("senderId")long senderId, @PathVariable("receiverId")long receiverId) {
	     //   if (UserSession.hasId(senderId) || UserSession.isAdmin())
	            return chatService.getConversation(senderId, receiverId);
	    }


}