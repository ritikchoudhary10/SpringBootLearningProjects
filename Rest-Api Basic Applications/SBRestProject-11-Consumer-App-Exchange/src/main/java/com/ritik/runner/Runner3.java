package com.ritik.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

//@Component
public class Runner3 implements CommandLineRunner {

	@Autowired
	private RestTemplate t;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public void run(String... args) throws Exception {
		//storing the service url 
		String serviceUrl = "http://localhost:9091/SBRestProject-11-SwaggerUi-integration/tourist-api/update/{id}/{updatedBudget}";
	
		
		ResponseEntity<String> exchange = t.exchange(serviceUrl, HttpMethod.PUT ,null , String.class ,2 ,500000.0);
		
		System.out.println(exchange.getBody());
		
		System.exit(0);
	}

}
