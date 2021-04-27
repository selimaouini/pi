package tn.pi.Controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.pi.Repository.ChatRepository;

@Scope(value = "session")
@Controller(value = "chatController")
@ELBeanName(value = "chatController")
@Join(path = "/", to = "/chat.jsf")
public class ControllerChatImpl {
	@Autowired 
	ChatRepository chatRepository; 
}
