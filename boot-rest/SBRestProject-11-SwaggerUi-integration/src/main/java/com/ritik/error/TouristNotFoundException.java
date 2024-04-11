package com.ritik.error;

@SuppressWarnings("serial")
public class TouristNotFoundException extends RuntimeException{

	public TouristNotFoundException(String exceptionMsg) {
	   super(exceptionMsg);
	}
	
}
