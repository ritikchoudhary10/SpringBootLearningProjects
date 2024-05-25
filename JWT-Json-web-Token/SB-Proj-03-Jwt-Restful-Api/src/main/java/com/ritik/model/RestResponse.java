package com.ritik.model;

import java.security.Principal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse {

	private Principal user;
	private Object requestedData;
	
	public static RestResponse response(Principal user ,Object requestedData) {
		return new RestResponse(user, requestedData);
	}
}
