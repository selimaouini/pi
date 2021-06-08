package tn.pi.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import tn.pi.entities.Event;

public interface IEventService {
	public String save();

	public Event getEvent();

	public String delete(int id);

	public String modifier(Event e, String name, String adress, Date date);

	public void loadData();

	public List<Event> getEvents();

	public String saveModif();

	public Event getEventById(int id);

}
