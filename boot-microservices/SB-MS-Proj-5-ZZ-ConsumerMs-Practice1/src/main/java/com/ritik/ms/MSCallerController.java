package com.ritik.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.client.IClientProducerMS;
import com.ritik.model.Tourist;

@RestController
@RequestMapping("/consumer-api")
public class MSCallerController {

	@Autowired
	private IClientProducerMS client;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		ResponseEntity<String> registerTourist = client.registerTourist(tourist);
		return new ResponseEntity<String>(registerTourist.getBody()+"Data consumer by consumer from provider",HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		ResponseEntity<?> byId = client.findById(id);
		if(byId.getStatusCode().is4xxClientError())
			return new ResponseEntity<>(byId.getBody() , HttpStatus.OK);
		return new ResponseEntity<>(byId.getBody() , HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Tourist>> getAll(){
		return client.getAllTouristData();
	}
}
