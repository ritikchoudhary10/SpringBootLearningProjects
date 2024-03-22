package com.ritik.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider-api")
public class PathVarDemo {
	
	@GetMapping("/{data1}")
	public ResponseEntity<String>  method1(@PathVariable("data1") Integer no) {
		return new ResponseEntity<String>("data passed "+no , HttpStatus.OK);
		
	}

}
