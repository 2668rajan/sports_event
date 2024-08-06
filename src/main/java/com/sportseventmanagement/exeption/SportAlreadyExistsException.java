package com.sportseventmanagement.exeption;

public class SportAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public SportAlreadyExistsException() {
		super();
	}
	
	public SportAlreadyExistsException(String message) {
		super(message);
	}
	
}
