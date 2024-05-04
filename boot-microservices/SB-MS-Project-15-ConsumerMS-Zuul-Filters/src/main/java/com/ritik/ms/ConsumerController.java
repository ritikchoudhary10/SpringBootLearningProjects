package com.ritik.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.client.ConsumerClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/consumer-api")
public class ConsumerController {

	@Autowired
	private ConsumerClient client;
	
	@GetMapping("/wish/{name}")
	public ResponseEntity<String> wishMe(@PathVariable(required = true) String name){
		log.debug("Start of wishMe() method of ConsumerController");
		String body = client.getWish().getBody();
		log.info("FeignClient generated result from providerMS is "+body);
		log.debug("Start of wishMe() method of ConsumerController");
		return new ResponseEntity<String>(body+name,HttpStatus.OK);
	}
}
