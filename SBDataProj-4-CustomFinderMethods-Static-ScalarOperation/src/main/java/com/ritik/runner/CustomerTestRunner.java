package com.ritik.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ritik.service.ICustService;

@Component
public class CustomerTestRunner implements CommandLineRunner {

	@Autowired
	private ICustService ser;

	@Override
	public void run(String... args) throws Exception {
		
		
		}
}
