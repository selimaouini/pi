package tn.esprit.spring.controller;

import java.util.Date;

import tn.esprit.spring.entity.Event;

public interface IEventController {
	 public String save();
	 public Event getEvent();
	 public String delete(int id);
	 public String modifier(Event e, String title, String adress, Date date);
	 public String saveModif();


}
