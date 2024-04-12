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
public class WishMessageService {

	@Autowired
	private DiscoveryClient client;
	
	public String getWishFromProviderMS() {
		//getting the ProviderMs instance from eureka server using DiscoveryClient 
		
		List<ServiceInstance> instances = client.getInstances("PROVIDER_MS");
		
		//getting first instance from the list
		ServiceInstance serviceInstance = instances.get(0);
		
		//getting url from the serviceInstance
		String url = serviceInstance.getUri()+"/ms-project/wishme";
		
		//create RestTemplate object
		RestTemplate template =new RestTemplate();
		
		//making the request to the provider microservice
		ResponseEntity<String> exchange = template.exchange(url, HttpMethod.GET, null, String.class);
		return exchange.getBody();
	}
}
