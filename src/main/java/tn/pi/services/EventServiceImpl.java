package tn.pi.services;



import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tn.pi.entities.Donation;
import tn.pi.entities.Event;
import tn.pi.repositories.EventRepository;

@Service

public class EventServiceImpl implements IEventService
{   
	private Event event = new Event();
	private List<Event> events;
	@Autowired
	EventRepository eventRepository;
	



	public String save(){
		eventRepository.save(event);
		event = new Event();
		
		return "/event-list.xhtml?faces-redirect=true";
	}


	public Event getEvent() {

		return event;
	}
	@Override
	public Event getEventById(int id) {
		Event e = eventRepository.findById(id).get();
		return e;
	}


	public String delete(int id) {
		Event e =eventRepository.findById(id).get();
		eventRepository.delete(e);
		return "/event-list.xhtml?faces-redirect=true";
	}


	public String modifier(Event e, String title, String adress, Date date) {
		event=e;
		return "/event-form-modif.xhtml?faces-redirect=true";


	}


	public void loadData() {
		events = (List<Event>) eventRepository.findAll();

	}


	public List<Event> getEvents() {
		return events;
	}



	public String saveModif() {
		Event e1=eventRepository.findById(event.getId()).get();
		e1.setTitle(event.getTitle());
		e1.setAdress(event.getAdress());
		e1.setDate(event.getDate());
		eventRepository.save(e1);
		event = new Event();
		return "/event-list.xhtml?faces-redirect=true";
	}


	






}
