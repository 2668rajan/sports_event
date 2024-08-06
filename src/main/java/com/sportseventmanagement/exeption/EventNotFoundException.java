package com.sportseventmanagement.exeption;

public class EventNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public EventNotFoundException() {
		super();
	}
	
	public EventNotFoundException(String message) {
		super(message);
	}

}
