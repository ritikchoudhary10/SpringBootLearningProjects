package com.ritik.ms;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms-project")
public class MSController {

	@GetMapping("/wishme")
	public ResponseEntity<String> getWish(){
		int hour = LocalDateTime.now().getHour();
		if(hour>=6 && hour<12)
			return new ResponseEntity<String>("Good Morning ", HttpStatus.OK);
		if(hour>=12 && hour<18)
			return new ResponseEntity<String>("Good Afternoon" ,HttpStatus.OK);
		return new  ResponseEntity<String>("Good Evening" , HttpStatus.OK);
	}
}
