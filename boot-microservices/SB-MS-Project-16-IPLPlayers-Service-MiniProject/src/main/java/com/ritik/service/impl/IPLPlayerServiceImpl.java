package com.ritik.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.entity.IPLPlayer;
import com.ritik.repository.IPLPlayerRepository;
import com.ritik.service.IPLPlayerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IPLPlayerServiceImpl implements IPLPlayerService {

	@Autowired
	private IPLPlayerRepository playerRepo;
	
	
	@Override
	public String savePlayer(IPLPlayer player) {
		log.info("IPLPlayerServiceImpl.savePlayer()");
		log.info("player info--> "+player);
		Integer playerId = playerRepo.save(player).getPId();
		log.info("generated player id--> "+playerId);
		return "Player details with Id--> "+playerId+" saved successfully.";
	}

	@Override
	public IPLPlayer getPlayer(Integer pId) throws Exception {
		//getting the optional object which may or may not contain player object
		log.info("IPLPlayerServiceImpl.getPlayer()");
		log.info("player id received--> "+pId);
		Optional<IPLPlayer> player = playerRepo.findById(pId);
		// checking for player details avaialable or not 
		if(player.isEmpty()) {
			log.info("optional object is empty throwing exception");
			throw new IllegalArgumentException("Player with id--> "+pId+" doesn't exist, please check the id again.");
		}
		// returning the player object if available
		log.info("player details have sent successfully");
		return player.get();
	}

	@Override
	public List<IPLPlayer> findAllPlayer() {
		log.info("IPLPlayerServiceImpl.findAllPlayer()");
		log.info("all data of players are collected");
		List<IPLPlayer> allPlayers = playerRepo.findAll();
		return allPlayers;
	}

	
}
