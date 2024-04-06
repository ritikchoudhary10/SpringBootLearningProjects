package com.ritik.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//@Order(1)
//@Component
public class Runner2_RestTemplate implements CommandLineRunner{
	
	@Autowired
	private RestTemplate rest;
	
	
	@Override
	public void run(String... args) throws Exception {
		// service url for geting tourist details using id
		System.out.println("============================================================================================================================");
		String serviceUr="http://localhost:8082/SBRestProj-10-ProviderApplication/tourist-api/report/findById/{id}";
		//get this id tourist details
		int id = 2;
		//call getForEntity()  method since get method doesnt required any header or body details so no need of creating HttpEntity object.
		 ResponseEntity<String> response = rest.getForEntity(serviceUr, String.class , id);
		 
		 System.out.println(response.getBody());
		 System.out.println("the data above shown is in text data bcz every thing that travels over the network is in the form of text data");
		System.out.println("============================================================================================================================");
	}
}
