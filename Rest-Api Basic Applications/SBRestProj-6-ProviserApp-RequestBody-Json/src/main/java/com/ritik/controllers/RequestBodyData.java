package com.ritik.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.model.Student;

@RestController
@RequestMapping("/provider-api")
public class RequestBodyData {

	@PostMapping("/register")
	public ResponseEntity<Student> register(@RequestBody(required = true) Student std){
		System.out.println(std);
		return new ResponseEntity<Student>(std , HttpStatus.ACCEPTED);
		
	}
}
