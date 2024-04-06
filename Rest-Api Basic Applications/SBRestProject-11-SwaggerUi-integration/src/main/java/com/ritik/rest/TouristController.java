package com.ritik.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.entity.Tourist;
import com.ritik.error.BudgetUpdateError;
import com.ritik.error.TouristNotFoundException;
import com.ritik.service.ITouristService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(info = @Info(title = "Tourist-Api", version = "1.0.0", contact = @Contact(email = "helloworld@xyz.pqr", name = "Hello World Programmer")))

@RestController
@RequestMapping("/tourist-api")
@Tag(name = "Tourist-API", description = "Tourist-API for performing CRUD operations ")
public class TouristController {
	
	@Autowired
	private ITouristService ser;

	@Operation(description = "This post api call will register the tourist and save record in the database", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true), responses = {
			@ApiResponse(responseCode = "400", description = "Tourist data format error" ),
			@ApiResponse(responseCode = "201", description = "Tourist registered successfully") }, summary = "Registering the Tourist"

	)
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist) {
		String registerTourist = ser.registerTourist(tourist);
		return new ResponseEntity<String>(registerTourist, HttpStatus.CREATED);
	}

	@Operation(description = "This get api call will provide the detaills of the tourists based on given id", responses = {
			@ApiResponse(responseCode = "500", description = "Tourist with the id is unavailable",content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation =TouristNotFoundException.class)) ),
			@ApiResponse(responseCode = "200", description = "Tourist with the id is available" ,content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation =Tourist.class))) }, summary = "Get Tourist by id value")
	@GetMapping("/report/findById/{id}")
	public ResponseEntity<?> getTouristById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<Tourist>(ser.fetchTouristById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Operation(description = "This get api call will provide all tourist details available in Database", responses = {
			@ApiResponse(responseCode = "200", description = "All Tourist data sended successfullyt") }, summary = "Get All Tourist Details")
	@GetMapping("/report/allTourist")
	public ResponseEntity<List<Tourist>> getAllTourists() {
		return new ResponseEntity<List<Tourist>>(ser.fetchAllTourists(), HttpStatus.OK);
	}

	@Operation(description = "This path api call will update the budget of tourist with given id", responses = {
			@ApiResponse(responseCode = "500", description = "Tourist with the id is unavailable (OR) new Budget can not be less than or equal to previous budget" ,content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation =BudgetUpdateError.class))),
			@ApiResponse(responseCode = "200", description = "Tourist budget updated",content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation =String.class))) }, summary = "Update the tourist budget og given id ")
	@PutMapping("/update/{id}/{updatedBudget}")
	public ResponseEntity<?> updateBudget(@PathVariable Integer id, @PathVariable Double updatedBudget) {
		try {
			return new ResponseEntity<String>(ser.updateBudget(id, updatedBudget), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(description = "This path api call will provide all tourist having budget int the given range.",
			responses = {	@ApiResponse(responseCode = "500", description = "then budget range start value is smaller than the end valu8es of budget range" ,content = @Content(mediaType = "application/json",
							                    schema = @Schema(implementation =IllegalArgumentException.class))),
										@ApiResponse(responseCode = "200", description = "tourist details in the given given range if budget" ,content = @Content(mediaType = "application/json",
												schema = @Schema(implementation = List.class))) }, summary = "find the tourist with the budget in the given range")

	@GetMapping("/report/{start}/{end}")
	public ResponseEntity<?> fetchByBudgetBetween(Double start, Double end) {
		
		try {
			if (start > end)
				throw new IllegalArgumentException("start value must be gless than end value");
		} catch (Exception e) {
			return new ResponseEntity<>(e ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Tourist>>(ser.getTouristWithRange(start, end), HttpStatus.OK);
	}

	@Operation(description = "This path api ca)ll will update the budget of tourist with given id", 
							 responses = {@ApiResponse(responseCode = "500", description = "Tourist doesnot exist with the given id" ,content = @Content(schema =@Schema(contentSchema = TouristNotFoundException.class) , mediaType ="application/json")),
									  					@ApiResponse(responseCode = "200", description = "Tourist deleted ",content = @Content(schema =@Schema(contentSchema = String.class) , mediaType ="application/json")) }, 
							 summary = "Delete the tourist with the given id value")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTouristById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<String>(ser.deleteTourist(id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.OK);

		}
	}

}
