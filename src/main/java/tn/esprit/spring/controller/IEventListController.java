package tn.esprit.spring.controller;

import java.util.List;

import tn.esprit.spring.entity.Event;

public interface IEventListController {
	 public void loadData();
	 public List<Event> getEvents();
}
