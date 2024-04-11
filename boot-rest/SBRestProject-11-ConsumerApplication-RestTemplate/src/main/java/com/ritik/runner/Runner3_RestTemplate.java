package com.ritik.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Order(3)
//@Component
public class Runner3_RestTemplate implements CommandLineRunner {

	@Autowired
	private RestTemplate rest;
	@Override
	public void run(String... args) throws Exception {
		//specifying service url
		String serviceUrl="http://localhost:8082/SBRestProject-10-ProviderApplication/tourist-api/report/allTourist";
		//calling getForObject() method
		// the speciality of this method is we doesnt get response headers and other details 
		// we only get the responseBody as the return value of this method
		
		String responseBody = rest.getForObject(serviceUrl, String.class);
		
		String[] split = responseBody.split("},");
		
		for(String s: split) {
			System.out.println(s);
		}
		
	}

}
