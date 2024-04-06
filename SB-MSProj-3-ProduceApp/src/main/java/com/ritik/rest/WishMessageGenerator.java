package com.ritik.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishgenerator")
public class WishMessageGenerator {

	@GetMapping("/wishMe/{name}")
	public ResponseEntity<String> wishMe(@PathVariable(required = true) String name) {
		LocalDateTime  dt=LocalDateTime.now();
		int hour = dt.getHour();
		
		if(hour>6 && hour<=12) 
			return new ResponseEntity<String>("Good Morning "+name,HttpStatus.OK);
		
		if(hour>12 && hour<=17)
			return new ResponseEntity<String>("Good Afternoon "+name,HttpStatus.OK);
		return new ResponseEntity<String>("Good Evening  "+name,HttpStatus.OK);
	}
	
}
