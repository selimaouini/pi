package tn.pi.controllers;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tn.pi.entities.Event;
import tn.pi.repositories.EventRepository;
import tn.pi.services.IEventService;

import java.util.List;
//@Scope (value = "session")

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@Scope (value = "session")
@Component (value = "eventList")
@ELBeanName(value = "eventList")
@Join(path = "/events", to = "/event-list.jsf")
public class EventListController implements IEventListController{
	private List<Event> events;
	
	@Autowired
	IEventService iEventService;
	@Deferred
	@RequestAction
	@IgnorePostback
    public void loadData() {
        iEventService.loadData();
    }
    public List<Event> getEvents() {
    	events=iEventService.getEvents();
        return events;
    }
}