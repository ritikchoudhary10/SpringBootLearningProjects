package com.ritik.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ritik.service.WishingServiceRestConsumer;

@RestController
@RequestMapping("/consumer-api")
public class WishController {
	
	@Autowired
	private WishingServiceRestConsumer ser;

	@GetMapping("/wish/{name}")
	public ResponseEntity<String> getWish(@PathVariable(required=true) String name){
		//getting the response 
		return new ResponseEntity<String>(ser.getWish(name),HttpStatus.OK);
	}
	
}
