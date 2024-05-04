package com.ritik.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shopping-api")
public class MS_2_Controller {

	@GetMapping("/call")
	public ResponseEntity<String> call() {
		return new ResponseEntity<String>("Executed from Microservice-2",HttpStatus.OK);
	}
	
}
