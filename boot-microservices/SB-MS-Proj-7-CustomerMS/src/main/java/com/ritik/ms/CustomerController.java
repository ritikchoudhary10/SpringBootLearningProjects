package com.ritik.ms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {
	
	@Value("${db.username}")
	private String user;
	
	@Value("${db.password}")
	private String pass;
	
	@GetMapping("/display")
	public String ConfigPropertyInfo() {
		return "username and password getting from config server in CustomerMS \nusername-->"+user+"\npassword-->"+pass;
	}
}
