package com.ritik.ms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/employee-api")
public class EmployeeController {

	@Value("${db.username}")
	private String user;
	
	@Value("${db.password}")
	private String pass;
	
	@GetMapping("/show")
	public String ConfigPropertyInfo() {
		return "username and password getting from config server in EmployeeMS \nusername-->"+user+"\npassword-->"+pass;
	}
	
}
