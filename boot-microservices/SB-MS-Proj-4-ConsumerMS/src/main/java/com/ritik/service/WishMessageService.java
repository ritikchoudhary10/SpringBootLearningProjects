package com.ritik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class WishMessageService {

	@Autowired
	private LoadBalancerClient client;
	
	public String getWishFromProviderMS() {
		//getting the ProviderMs instance from eureka server using DiscoveryClient 
		ServiceInstance instance = client.choose("ProviderMS");
		
		//getting url from the serviceInstance
		String URL =instance.getUri()+"/ms-project/wishme";
		//create RestTemplate object
		RestTemplate template =new RestTemplate();
		//making the request to the provider microservice
		ResponseEntity<String> exchange = template.exchange(URL, HttpMethod.GET, null, String.class);
		return exchange.getBody();
	}
}
