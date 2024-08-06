package com.sportseventmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventmanagement.dao.EventDao;
import com.sportseventmanagement.entity.Event;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventDao eventDao;
	
	@Override
	public List<Event> getEvents() {
		return eventDao.findAll();
	}

	@Override
	public Event addEvent(Event event) {
		eventDao.save(event);
		return event;
	}

	@Override
	public Event updateEvent(Event event) {
		eventDao.save(event);
		return event;
	}

	@Override
	public void deleteEvent(long parseLong) {
		eventDao.deleteById(parseLong);
	}

	@Override
	public List<Event> getEventByeventName(String eventName) {
		return eventDao.findByeventName(eventName);	 
	}

	@Override
	public boolean eventExists(Long eventId) {
		return eventDao.existsById(eventId);
	}

}
