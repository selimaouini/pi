package tn.esprit.spring.controller;


import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.service.IDonationService;
import tn.esprit.spring.service.IEventService;


@Scope(value = "session")
@Component(value = "eventController")
@ELBeanName(value = "eventController")
@Join(path = "/eventForm", to = "/event-form.jsf")

public class EventController implements IEventController {
    
	@Autowired
	IEventService iEventService;
	IDonationService iDonationService;

	
	@Autowired
	private JavaMailSender javaMailSender;
	SimpleMailMessage msg = new SimpleMailMessage();
    
    public String save() {
 		String mailAdress="amir.ibenabdellah@esprit.tn";
 		MimeMessage message = javaMailSender.createMimeMessage();
 	    try {
 	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
 	        helper.setFrom("amirbenabdallah97@gmail.com");
 	        helper.setTo(mailAdress);
 	        helper.setSubject("Evenement");
 	        helper.setText("Cher client, \n \n"
 	        		+ "Nous voulons vous informer sur les détails de notre évenement: \n"
 	        		+"\t Titre: "+iEventService.getEvent().getTitle()+"\n"
 	        		+"\t Adress: " + iEventService.getEvent().getAdress()+"\n"
 	        		+"\t Date: "+ iEventService.getEvent().getDate()+"\n\n"
 	        		+"vous pouvez nous contacter sur notre platform 'Consommi Tounsi' pour contribuer à cet évévenement.\n"
 	        		+"Merci pour votre soutien\n\n"
 	        		+"equipe Consommi Tounsi"
 	        		);
 	        
 	        	        
 	        javaMailSender.send(message);
 	    } catch (MessagingException  e) {

 	        e.printStackTrace();
 	    }
    	
       return iEventService.save();
    }
    
    
    
    public Event getEvent() {
        return iEventService.getEvent();
    }
    public String delete(int id) {
    	String mailAdress="amir.ibenabdellah@esprit.tn";
 		MimeMessage message = javaMailSender.createMimeMessage();
 	    try {
 	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
 	        helper.setFrom("amirbenabdallah97@gmail.com");
 	        helper.setTo(mailAdress);
 	        helper.setSubject("Delete Evenement");
 	        helper.setText("Cher client, \n \n"
 	        		+ "Nous voulons vous informer sur les détails de notre évenement supprimé: \n"
 	        		+"\t Titre: "+iEventService.getEventById(id).getTitle()+"\n"
 	        		+"\t Adress: " + iEventService.getEventById(id).getAdress()+"\n"
 	        		+"\t Date: "+ iEventService.getEventById(id).getDate()+"\n\n"
 	        		+"vous pouvez nous contacter sur notre platform 'Consommi Tounsi' pour plus de visibilité sur nos événements.\n"
 	        		+"Merci pour votre soutien\n\n"
 	        		+"equipe Consommi Tounsi"
 	        		);
 	        
 	        	        
 	        javaMailSender.send(message);
 	    } catch (MessagingException  e) {

 	        e.printStackTrace();
 	    }
    	
    return iEventService.delete(id);
    }
   
    public String modifier(Event e, String title,String adress, Date date) {
    	
    	return iEventService.modifier(e, e.getTitle(),e.getAdress(), e.getDate());
    }
	
	public String saveModif() {
		String mailAdress="amir.ibenabdellah@esprit.tn";
 		MimeMessage message = javaMailSender.createMimeMessage();
 	    try {
 	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
 	        helper.setFrom("amirbenabdallah97@gmail.com");
 	        helper.setTo(mailAdress);
 	        helper.setSubject("update Evenement");
 	        helper.setText("Cher client, \n \n"
 	        		+ "Nous voulons vous informer sur les nouveaux détails de notre évenement: \n"
 	        		+"\t Titre: "+iEventService.getEvent().getTitle()+"\n"
 	        		+"\t Adress: " + iEventService.getEvent().getAdress()+"\n"
 	        		+"\t Date: "+ iEventService.getEvent().getDate()+"\n\n"
 	        		+"vous pouvez nous contacter sur notre platform 'Consommi Tounsi' pour contribuer à cet évévenement.\n"
 	        		+"Merci pour votre soutien\n\n"
 	        		+"equipe Consommi Tounsi"
 	        		);
 	        
 	        	        
 	        javaMailSender.send(message);
 	    } catch (MessagingException  e) {

 	        e.printStackTrace();
 	    }
    	
		return iEventService.saveModif();
	}

	
	

}