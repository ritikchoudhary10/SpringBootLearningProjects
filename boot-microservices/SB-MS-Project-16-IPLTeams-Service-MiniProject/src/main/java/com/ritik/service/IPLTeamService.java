package com.ritik.service;

import java.util.List;

import com.ritik.entity.IPLTeam;

public interface IPLTeamService {

	public String saveTeam(IPLTeam team);
	public IPLTeam getTeamDetails(Integer tId) throws Exception;
	public List<IPLTeam> getAllTeamsDetails();
}
