package com.ritik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.entity.IPLTeam;
import com.ritik.service.IPLTeamService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/team-api")
public class IPLTeamController {

	@Autowired
	private IPLTeamService ser;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTeam(@RequestBody IPLTeam team){
		try {
			String teamSaved = ser.saveTeam(team);
			return new ResponseEntity<String>(teamSaved ,HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<IPLTeam> getTeamById(@PathVariable Integer id){
		try {
			IPLTeam teamDetails = ser.getTeamDetails(id);
			return new ResponseEntity<IPLTeam>(teamDetails ,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IPLTeam>> getAllTeams() {
		List<IPLTeam> allTeamsDetails = ser.getAllTeamsDetails();
		return new ResponseEntity<List<IPLTeam>>(allTeamsDetails ,HttpStatus.OK);
	}
	
}
