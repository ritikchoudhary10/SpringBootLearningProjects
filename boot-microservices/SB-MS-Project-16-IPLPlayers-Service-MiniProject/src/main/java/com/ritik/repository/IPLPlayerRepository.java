package com.ritik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritik.entity.IPLPlayer;

public interface IPLPlayerRepository extends JpaRepository<IPLPlayer, Integer> {

}
