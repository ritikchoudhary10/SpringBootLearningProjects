package com.ritik.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.entity.Tourist;
import com.ritik.service.ITouristService;

@RestController
@RequestMapping("/tourist-api")
public class TouristController {

	@Autowired
	private ITouristService ser;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		String registerTourist = ser.registerTourist(tourist);
		return new ResponseEntity<String>(registerTourist,HttpStatus.CREATED);
	}
	
	@GetMapping("report/findById/{id}")
	public ResponseEntity<Tourist> getTouristById(@PathVariable Integer id){
		return new ResponseEntity<Tourist>(ser.fetchTouristById(id),HttpStatus.OK);
	}
	
	@GetMapping("report/allTourist")
	public ResponseEntity<List<Tourist>> getAllTourists(){
		return new ResponseEntity<List<Tourist>>(ser.fetchAllTourists(),HttpStatus.OK);
	}
	
	@PatchMapping("/update/{id}/{updatedBudget}")
	public ResponseEntity<String> updateBudget(@PathVariable Integer id , @PathVariable Double updatedBudget){
		return new  ResponseEntity<>(ser.updateBudget(id ,updatedBudget),HttpStatus.OK);
	}
	
	@GetMapping("report/{start}/{end}")
	public ResponseEntity<List<Tourist>> fetchByBudgetBetween(Double start , Double end){
		return new ResponseEntity<List<Tourist>>(ser.getTouristWithRange(start, end) , HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable Integer id){
		return new ResponseEntity<String>(ser.deleteTourist(id),HttpStatus.OK);
	}
	
	
	
}
