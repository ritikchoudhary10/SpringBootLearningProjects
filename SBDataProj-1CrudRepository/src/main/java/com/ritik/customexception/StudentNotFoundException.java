package com.ritik.customexception;

@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String exceptionMsg) {
		super(exceptionMsg);
	}
	
}
