package tn.pi.controllers;

import java.util.List;

import tn.pi.entities.Event;

public interface IEventListController {
	 public void loadData();
	 public List<Event> getEvents();
}
