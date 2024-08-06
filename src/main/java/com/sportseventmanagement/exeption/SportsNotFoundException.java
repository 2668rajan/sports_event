package com.sportseventmanagement.exeption;

public class SportsNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public SportsNotFoundException() {
		super();
	}
	
	public SportsNotFoundException(String message) {
		super(message);
	}

}
