package com.ritik.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishgenerator")
public class WishMessageGenerator {

	@GetMapping("/wishMe/{name}")
	public String wishMe(@PathVariable(required = true) String name) {
		LocalDateTime  dt=LocalDateTime.now();
		int hour = dt.getHour();
		
		if(hour>6 && hour<=12) 
			return "Good Morning "+name;
		
		if(hour>12 && hour<=17)
			return "Good Afternoon "+name;
		return "Good Evening "+name;
	}
	
}
