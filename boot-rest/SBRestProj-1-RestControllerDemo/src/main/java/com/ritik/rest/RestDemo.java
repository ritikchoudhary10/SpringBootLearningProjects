package com.ritik.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-api")
public class RestDemo {

	@GetMapping("/get")
	public ResponseEntity<String> demo(){
		return new ResponseEntity<String>("get mode method called..!" , HttpStatus.OK);
	}
}
