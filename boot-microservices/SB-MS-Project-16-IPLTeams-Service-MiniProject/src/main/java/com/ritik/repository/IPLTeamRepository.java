package com.ritik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritik.entity.IPLTeam;

public interface IPLTeamRepository extends JpaRepository<IPLTeam, Integer> {

}
