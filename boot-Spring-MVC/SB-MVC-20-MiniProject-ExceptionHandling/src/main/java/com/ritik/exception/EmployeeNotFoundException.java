package com.ritik.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus( code = HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException() {
	}
	public EmployeeNotFoundException(String message) {

		super(message);
	}
	
	
					
}
