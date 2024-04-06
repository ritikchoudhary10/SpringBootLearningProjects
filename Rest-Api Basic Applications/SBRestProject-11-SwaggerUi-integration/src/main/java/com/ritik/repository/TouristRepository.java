package com.ritik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ritik.entity.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Integer> {

	@Query(nativeQuery = true ,value = "SELECT * FROM Tourist_data WHERE budget>= :start AND  budget<= :end")
	public List<Tourist> fetchByBudgetBetween(Double start, Double end);
}
