package com.ritik.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Order(4)
//@Component
public class Runner4_RestTemplate implements CommandLineRunner {

	@Autowired
	private RestTemplate rest;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("============================================================================================================================");
		//url request path for register the tourist
		String serviceUrl="http://localhost:8082/SBRestProj-10-ProviderApplication/tourist-api/update/{id}/{updatedBudget}";		
		int id =103;
		double updatedBudget=50000.0;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> req = new HttpEntity<String>(headers);
		
		 ResponseEntity<String> exchange = rest.exchange(serviceUrl, HttpMethod.POST,req, String.class, id , updatedBudget);
		
		System.out.println(exchange.getBody());
		System.out.println("============================================================================================================================");
		//System.out.println(response.getStatusCode());
		//System.out.println(response.getHeaders());
		
		
	}

}
