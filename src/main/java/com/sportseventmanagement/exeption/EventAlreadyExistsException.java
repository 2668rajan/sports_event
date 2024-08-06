package com.sportseventmanagement.exeption;

public class EventAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EventAlreadyExistsException() {
		super();
	}
	
	public EventAlreadyExistsException(String message) {
		super(message);
	}
	
}
