package com.sportseventmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportseventmanagement.dao.SportsDao;
import com.sportseventmanagement.entity.Event;
import com.sportseventmanagement.entity.Sports;
import com.sportseventmanagement.exeption.AuthenticationException;
import com.sportseventmanagement.exeption.EventAlreadyExistsException;
import com.sportseventmanagement.exeption.EventNotFoundException;
import com.sportseventmanagement.exeption.SportAlreadyExistsException;
import com.sportseventmanagement.exeption.SportsNotFoundException;
import com.sportseventmanagement.feign.Iproxy;
import com.sportseventmanagement.service.EventService;
import com.sportseventmanagement.service.SportsService;

@RestController
@RequestMapping("/sportsevent")
public class SportsEventController {
	
	@Autowired
	private Iproxy iproxy;
	
	@Autowired
	private SportsService sportsService;
	
	@Autowired
	private EventService eventService;
	
	Logger log = LoggerFactory.getLogger(SportsEventController.class);
	
	@GetMapping("/home")
	public String home() {
		return "welcome page of sports event management microservice";
	}
	
	//get all sports
	@GetMapping("/sports")
	public List<Sports> getSports(@RequestHeader(value = "Authorization", required = true) String token1) throws SportsNotFoundException, AuthenticationException {
		if(iproxy.getvalidation(token1)) {
			List<Sports> sports = sportsService.getSports();
			if(sports.isEmpty()) {
				throw new SportsNotFoundException("Sports Not Found");
			}
			
			log.info("Sports list fetched: "+sports);
			
			return sports;
		}else {
			throw new AuthenticationException("You are not authorized");
		}
	}
	
	//get sport by a name
	@GetMapping("/sports/{sportsName}")
	public List<Sports> getSportByName(@PathVariable String sportsName, @RequestHeader(value = "Authorization", required = true) String token1) throws SportsNotFoundException, AuthenticationException {
		if(iproxy.getvalidation(token1)) {
			
			List<Sports> bysportsName = sportsService.getSportBysportsName(sportsName);
			if(bysportsName.isEmpty()) {
				throw new SportsNotFoundException("Sports not found");
			}
			
			log.info("Sports with name "+ sportsName +" are "+bysportsName);
			
			return bysportsName;
		}else {
			throw new AuthenticationException("You are not authorized");
		}
	}
	
	//add a sports
	@PostMapping("/sports")
	public ResponseEntity<String> addSports(@RequestBody Sports sport, @RequestHeader(value = "Authorization", required = true) String token1) throws SportAlreadyExistsException, AuthenticationException {
		if(iproxy.getvalidation(token1)) {
			if(sportsService.sportsExists(sport.getSportsName())) {
				throw new SportAlreadyExistsException("Sports already exists");
			}
			sportsService.addSports(sport);
			
			log.info("Sport with sport Id "+sport.getSportsId()+" added successfuly");
			
			return new ResponseEntity<>("Sport Created Successfully!",HttpStatus.CREATED);
		}else {
			throw new AuthenticationException("You are not authorized");
		}
	}
	
	//get all events
	@GetMapping("/events")
	public List<Event> getEvents(@RequestHeader(value = "Authorization", required = true) String token1) throws EventNotFoundException, AuthenticationException{
		if(iproxy.getvalidation(token1)) {
			List<Event> events = eventService.getEvents();
			if(events.isEmpty()) {
				throw new EventNotFoundException("Events not found");
			}
			log.info("Events list fetched: "+events);
			return events;
		}
		else {
			throw new AuthenticationException("You are not authorized");
		}
	}
	
	//add an event
	@PostMapping("/events")
	public ResponseEntity<String> addEvent(@RequestBody Event event, @RequestHeader(value = "Authorization", required = true) String token1) throws EventAlreadyExistsException, AuthenticationException {
		if(iproxy.getvalidation(token1)) {
			if(eventService.eventExists(event.getEventId())) {
				throw new EventAlreadyExistsException("Event already exits");
			}
			eventService.addEvent(event);
			log.info("Event with sport Id "+event.getEventId()+" added successfuly");
			
			return new ResponseEntity<>("Event Created Successfully!",HttpStatus.CREATED);
		}else {
			throw new AuthenticationException("You are not authorized");
		}
	}
	
	//get event by name
	@GetMapping("/events/{eventName}")
	public List<Event> getEventByName(@PathVariable String eventName, @RequestHeader(value = "Authorization", required = true) String token1) throws EventNotFoundException, AuthenticationException{
		if(iproxy.getvalidation(token1)) {
			List<Event> byeventName = eventService.getEventByeventName(eventName);
			if(byeventName.isEmpty()) {
				throw new EventNotFoundException("Event not found");
			}
			log.info("Event with name "+eventName + " are : "+byeventName);
			
			return byeventName;
		}else {
			throw new AuthenticationException("You are not authorized");
		}
		
	}
	
	//update an event
	@PutMapping("/events")
	public Event updateEvent(@RequestBody Event event, @RequestHeader(value = "Authorization", required = true) String token1) throws EventNotFoundException, AuthenticationException {
		if(iproxy.getvalidation(token1)) {
			if(eventService.eventExists(event.getEventId())) {
				Event updateEvent = eventService.updateEvent(event);
				log.info("Event with id "+event.getEventId()+"updated successfully");
				return updateEvent;
			}else {
				throw new EventNotFoundException("Event Not Found");
			}
			
		}else {
			throw new AuthenticationException("You are not authorized");
		}
	}
	
	//delete an event
	@DeleteMapping("/events/{eventId}")
	public ResponseEntity<HttpStatus> deleteEvent(@PathVariable Long eventId, @RequestHeader(value = "Authorization", required = true) String token1) throws EventNotFoundException {
		
		if(iproxy.getvalidation(token1)) {
			if(eventService.eventExists(eventId)) {
				try {
					this.eventService.deleteEvent(eventId);
					return new ResponseEntity<>(HttpStatus.OK);
				}
				catch(Exception e){
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}else {
				throw new EventNotFoundException("Event not found");
			}
		}else {
			return null;
		}
	}

}
