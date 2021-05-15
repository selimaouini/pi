package tn.esprit.spring.controller;

import tn.esprit.spring.entity.Event;

public interface IEventController {
	 public String save();
	 public Event getEvent();
	 public String delete(int id);
	 public String modifier(Event e, String title, String adress, String date);
	 public String saveModif();


}
