package com.ritik.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider-api")
public class RestProviderApi {
	
	@GetMapping("/get")
	public ResponseEntity<String> getData(){
		return new ResponseEntity<String>("Get method called",HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> postData(){
		return new ResponseEntity<String>("Post method called",HttpStatus.OK);
	}	

	@PutMapping("/put")
	public ResponseEntity<String> putData(){
		return new ResponseEntity<String>("Put method called",HttpStatus.OK);
	}

}
