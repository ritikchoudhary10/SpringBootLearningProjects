package com.ritik.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ritik.model.Tourist;

//@Component
public class Runner4 implements CommandLineRunner {

	@Autowired
	private RestTemplate t;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public void run(String... args) throws Exception {
		//storing the service url 
		String serviceUrl = "http://localhost:9091/SBRestProject-11-SwaggerUi-integration/tourist-api/delete/{id}";
		
		ResponseEntity<String> exchange = t.exchange(serviceUrl, HttpMethod.DELETE ,null , String.class ,272);
		
		System.out.println(exchange.getBody());
		
		System.exit(0);
	}

}
