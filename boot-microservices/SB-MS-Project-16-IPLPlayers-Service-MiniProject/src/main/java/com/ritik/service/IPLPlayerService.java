package com.ritik.service;

import java.util.List;

import com.ritik.entity.IPLPlayer;

public interface IPLPlayerService {

	public String savePlayer(IPLPlayer player);
	public IPLPlayer getPlayer(Integer pId) throws Exception;
	public List<IPLPlayer> findAllPlayer();
	
}
