package tn.esprit.spring.service;



import java.util.List;

import tn.esprit.spring.entity.Event;

public interface IEventService {
	 public String save();
	 public Event getEvent();
	 public String delete(int id);
	 public String modifier(Event e, String name, String adress, String date);
	 public void loadData();
	 public List<Event> getEvents();
	 public String saveModif();




	
}
