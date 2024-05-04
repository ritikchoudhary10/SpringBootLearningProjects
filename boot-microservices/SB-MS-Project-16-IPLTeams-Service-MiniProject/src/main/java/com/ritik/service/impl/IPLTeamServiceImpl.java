package com.ritik.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.entity.IPLTeam;
import com.ritik.repository.IPLTeamRepository;
import com.ritik.service.IPLTeamService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class IPLTeamServiceImpl implements IPLTeamService {

	@Autowired
	private IPLTeamRepository teamRepo;
	
	@Override
	public String saveTeam(IPLTeam team) {
		log.info("IPLTeamServiceImpl.saveTeam()");
		Integer teamId = teamRepo.save(team).getTeamId();
		log.info("generated team id is--> "+teamId);
		return "Team registered with Team ID--> "+teamId;
	}

	@Override
	public IPLTeam getTeamDetails(Integer tId) throws Exception {
		log.info("IPLTeamServiceImpl.getTeamDetails()");
		//getting the optional object 
		Optional<IPLTeam> team = teamRepo.findById(tId);
		//checking the team details available or not
		if(team.isEmpty()) {
			log.info("team with the id doesn't exist ");
			throw new IllegalArgumentException("Team with given TeamId doesn't exist.");
		}
		log.info("team found and successfully returned to caller");
		return team.get();
	}
	
	@Override
	public List<IPLTeam> getAllTeamsDetails() {
		log.info("IPLTeamServiceImpl.getAllTeamsDetails()");
		List<IPLTeam> all = teamRepo.findAll();
		log.info("all the IPLTeams data reterieved successfully and sent");
		return all;
	}

}













