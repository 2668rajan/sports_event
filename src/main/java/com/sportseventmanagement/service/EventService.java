package com.sportseventmanagement.service;

import java.util.List;

import com.sportseventmanagement.entity.Event;

public interface EventService {

	List<Event> getEvents();

	Event addEvent(Event event);

	void deleteEvent(long parseLong);

	Event updateEvent(Event event);

	List<Event> getEventByeventName(String eventName);

	boolean eventExists(Long eventId);
	
}
