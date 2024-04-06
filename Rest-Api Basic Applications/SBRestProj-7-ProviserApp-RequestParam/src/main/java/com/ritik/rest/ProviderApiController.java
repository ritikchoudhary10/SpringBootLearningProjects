package com.ritik.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/provider-api")
public class ProviderApiController {
	@GetMapping("/single")
	public ResponseEntity<String> 	getParamvalues(@RequestParam("mailId") String param) {
		return new ResponseEntity<String>(param+" is passed in the url",HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> getCredentials(@RequestParam("user") String username , @RequestParam("password") String password  ){
		return new ResponseEntity<String>("username is "+username +"\n"+"Password is "+password ,HttpStatus.OK);
	}
	
}
