package tn.pi.controllers;

import java.util.Date;

import tn.pi.entities.Event;

public interface IEventController {
	 public String save();
	 public Event getEvent();
	 public String delete(int id);
	 public String modifier(Event e, String title, String adress, Date date);
	 public String saveModif();


}
