package tn.esprit.spring.controller;


import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.service.IDonationService;
import tn.esprit.spring.service.IEventService;


@Scope(value = "session")
@Component(value = "eventController")
@ELBeanName(value = "eventController")
@Join(path = "/event", to = "/event-form.jsf")

public class EventController implements IEventController {
    
	@Autowired
	IEventService iEventService;
    
    public String save() {
       return iEventService.save();
    }
    public Event getEvent() {
        return iEventService.getEvent();
    }
    public String delete(int id) {
    
    return iEventService.delete(id);
    }
   
    public String modifier(Event e, String title,String adress, String date) {
    	
    	return iEventService.modifier(e, e.getTitle(),e.getAdress(), e.getDate());
    }
	
	public String saveModif() {
		
		return iEventService.saveModif();
	}

	
	

}