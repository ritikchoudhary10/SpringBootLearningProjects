package com.ritik.model;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class ErrorMsg {
	
	private String reason;
	private HttpStatusCode code;

	public static ErrorMsg getError(String reason ,HttpStatusCode code ) {
		return new ErrorMsg(reason, code);
	}
}
