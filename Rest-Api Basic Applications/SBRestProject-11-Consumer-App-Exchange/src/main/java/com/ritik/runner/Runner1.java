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
public class Runner1 implements CommandLineRunner {

	@Autowired
	private RestTemplate t;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public void run(String... args) throws Exception {
		//storing the service url 
		String serviceUrl = "http://localhost:9091/SBRestProject-11-SwaggerUi-integration/tourist-api/register";
		// request object data 
		Tourist tourist = new Tourist("Raju","delux","Great Mountains", "15 days 14 nights", LocalDate.now(), LocalDate.of(2024, 10,15),500000.0);
		String jsonData = mapper.writeValueAsString(tourist);
		
		//create Headers
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//create http entity object 
		
		HttpEntity<String> requestBody = new HttpEntity<String>(jsonData,headers);
		
		ResponseEntity<String> exchange = t.exchange(serviceUrl, HttpMethod.POST ,requestBody , String.class);
		
		System.out.println(exchange.getBody());
		
		System.exit(0);
	}

}
