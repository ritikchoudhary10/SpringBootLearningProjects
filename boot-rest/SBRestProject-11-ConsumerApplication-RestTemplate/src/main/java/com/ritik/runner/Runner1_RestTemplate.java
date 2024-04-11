package com.ritik.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Order(2)
//@Component
public class Runner1_RestTemplate implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//    creating restTemplate object in every runner class instead we take the help of 
		//   @Bean method and we can inject in all runner classes using @Autowired annotation
		RestTemplate t = new RestTemplate();
		
		System.out.println("============================================================================================================================");
		//url request path for register the tourist
		String serviceUrl="http://localhost:8082/SBRestProject-10-ProviderApplication/tourist-api/register";
		//preparing heads details
		HttpHeaders header =new  HttpHeaders();
		//setting content type in header
		header.setContentType(MediaType.APPLICATION_JSON);
		//preparing json data for sending request in real time this jason data is generated using api's like jackson api and other
		String jsonBody="{"
				+ "  \"name\": \"Rahul\","
				+ "  \"packageType\": \"Delux\","
				+ "  \"packageName\": \"Buisness\","
				+ "  \"packageDuration\": \"3 days 2 nights\","
				+ "  \"startsFrom\": \"2024-03-29\","
				+ "  \"validTill\": \"2024-05-29\","
				+ "  \"budget\": 15000.0"
				+ "}";
		// creating httpentity for sending request body and headers
		
		HttpEntity<String> req = new HttpEntity<String>(jsonBody, header);
		
		ResponseEntity<String> response = t.postForEntity(serviceUrl , req,String.class);
		
		System.out.println(response.getBody());
		System.out.println("============================================================================================================================");
		//System.out.println(response.getStatusCode());
		//System.out.println(response.getHeaders());
		
		
	}

}
