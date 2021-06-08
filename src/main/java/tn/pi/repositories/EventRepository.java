package tn.pi.repositories;


import org.springframework.data.repository.CrudRepository;

import tn.pi.entities.Event;



public interface EventRepository extends CrudRepository<Event, Integer>  {

	
}
