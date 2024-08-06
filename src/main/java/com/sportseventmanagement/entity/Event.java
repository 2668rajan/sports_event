package com.sportseventmanagement.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Event {
	
	@Id
	//@GeneratedValue
	private Long eventId;
	private Date eventDate;
	//@NotNull(message = "Player name cannot be null")
	private String eventName;
	//@NotNull(message = "Player name cannot be null")
	private Long noOfSLots;
	//@NotNull(message = "Player name cannot be null")
	private String sportsName;
	
	public Event(Long eventId, Date eventDate, String eventName, Long noOfSLots, String sportsName) {
		super();
		this.eventId = eventId;
		this.eventDate = eventDate;
		this.eventName = eventName;
		this.noOfSLots = noOfSLots;
		this.sportsName = sportsName;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Long getNoOfSLots() {
		return noOfSLots;
	}
	public void setNoOfSLots(Long noOfSLots) {
		this.noOfSLots = noOfSLots;
	}
	public String getSportsName() {
		return sportsName;
	}
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventDate=" + eventDate + ", eventName=" + eventName + ", noOfSLots="
				+ noOfSLots + ", sportsName=" + sportsName + "]";
	}
	
	
}
