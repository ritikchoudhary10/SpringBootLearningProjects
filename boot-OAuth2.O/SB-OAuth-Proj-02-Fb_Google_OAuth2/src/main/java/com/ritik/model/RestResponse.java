package com.ritik.model;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse {

	private Object userInfo;
	private Object responseData;
	private HttpStatusCode responseStatusCode;
	
	public static RestResponse response(Object userInfo,Object responseData,HttpStatusCode responseStatusCode) {
		return new RestResponse(userInfo ,responseData,responseStatusCode);
	}
}
