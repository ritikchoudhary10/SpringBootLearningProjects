package com.ritik.ms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {
	
	
	
	@GetMapping("/display")
	public String ConfigPropertyInfo() {
		return "contoller data";
	}
}
