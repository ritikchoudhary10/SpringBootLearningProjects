package com.ritik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishingServiceRestConsumer {

	@Autowired
	private DiscoveryClient client;
	
	public String getWish(String name) {
		//get the instance of the ProducerMS 
		List<ServiceInstance> instances = client.getInstances("PROVIDERMS");
		ServiceInstance service = instances.get(0);
		
		//get the service uri info
		String s=service.getUri()+"/wishgenerator/wishMe/{name}";
		
		//make RestTemplate object
		RestTemplate template = new RestTemplate();
		
		//make the request and get the response from the service
		ResponseEntity<String> response = template.exchange(s, HttpMethod.GET, null, String.class, name);
		
		//return the response data
		return response.getBody();
	}
}
