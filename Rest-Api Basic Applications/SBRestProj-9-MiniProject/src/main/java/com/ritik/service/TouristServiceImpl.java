package com.ritik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.entity.Tourist;
import com.ritik.error.TouristNotFoundException;
import com.ritik.repository.TouristRepository;

@Service
public class TouristServiceImpl implements ITouristService {

	@Autowired
	TouristRepository repo;

	@Override
	public String registerTourist(Tourist tourist) {
		//System.out.println(tourist.getName());
		int tId = repo.save(tourist).getTId();
		return "Tourist save with id " + tId;
	}

	@Override
	public Tourist fetchTouristById(Integer id) throws TouristNotFoundException {
		return repo.findById(id)
				.orElseThrow(() -> new TouristNotFoundException("Tourist with id " + id + " does not exists"));
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		return repo.findAll();
	}

	@Override
	public String updateBudget(Integer id, Double budget) {
		Tourist t = repo.findById(id)
				.orElseThrow(() -> new TouristNotFoundException("Tourist with id " + id + " doesn't exist"));
		t.setBudget(budget);
		repo.save(t);
		return "Tourist budget has been ipdated with id " + id + " .";
	}

	@Override
	public List<Tourist> getTouristWithRange(Double start, Double end) {
		return repo.fetchByBudgetBetween(start, end);
	}

	@Override
	public String deleteTourist(Integer id) {
		if(!repo.existsById(id))
			return "Tourist with id "+id +" dowsn't exist";
		repo.deleteById(id);
		return "Tourist with id "+id +" has been deleted";
	}

}
