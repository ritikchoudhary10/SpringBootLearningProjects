package com.ritik.Rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xxxmapping-api")
public class RestAllXXXMappings {
	
	@GetMapping("/get")
	public ResponseEntity<String> callGetMapping(){
		return new ResponseEntity<String>("Get mapping method responded ...!",HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> callPostMapping(){
		return new ResponseEntity<String>("Post mapping method responded ...!",HttpStatus.OK);
	}
	
	@PutMapping("/put")
	public ResponseEntity<String> callPutMapping(){
		return new ResponseEntity<String>("Put mapping method responded ...!",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> callDeleteMapping(){
		return new ResponseEntity<String>("delete mapping method responded ...!",HttpStatus.OK);
	}
	
	@PatchMapping("/patch")
	public ResponseEntity<String> callPatchMapping(){
		return new ResponseEntity<String>("Patch mapping method responded ...!",HttpStatus.OK);
	}
	
	
	
}
