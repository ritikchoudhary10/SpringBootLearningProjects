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

import com.ritik.client.TeamMSClient;
import com.ritik.entity.IPLPlayer;
import com.ritik.entity.IPLTeam;
import com.ritik.service.IPLPlayerService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/player-api")
@Slf4j
public class IPLPlayerController {

	@Autowired
	private TeamMSClient client;
	
	@Autowired
	private IPLPlayerService ser;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerPlayer(@RequestBody IPLPlayer player){
		log.info("player in controller --> "+player);
		//getting team details
		ResponseEntity<IPLTeam> response = client.getTeamById(player.getTeam().getTeamId());
		//checking for response status
		if(response.getBody()==null)
			throw new IllegalArgumentException(response.getBody().toString());
		player.setTeam(response.getBody());
		String playerStatus = ser.savePlayer(player);
		return new ResponseEntity<String>(playerStatus , HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IPLPlayer>> getAllPlayerInfo(){
		List<IPLPlayer> allPlayer = ser.findAllPlayer();
		return new ResponseEntity<List<IPLPlayer>>(allPlayer ,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		try {
			IPLPlayer player = ser.getPlayer(id);
			return new ResponseEntity<IPLPlayer>(player ,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}















