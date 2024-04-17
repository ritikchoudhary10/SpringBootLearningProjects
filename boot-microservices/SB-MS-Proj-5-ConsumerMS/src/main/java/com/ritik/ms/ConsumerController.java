package com.ritik.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.client.ConsumerClient;

@RestController
@RequestMapping("/consumer-api")
public class ConsumerController {

	@Autowired
	private ConsumerClient client;
	
	@GetMapping("/wish/{name}")
	public ResponseEntity<String> wishMe(@PathVariable(required = true) String name){
		return new ResponseEntity<String>(client.getWish().getBody()+name,HttpStatus.OK);
	}
}
