package com.ritik.service;

import java.util.List;

import com.ritik.model.Tourist;

public interface ITouristService {

      	public String registerTourist(Tourist tourist) ;
      	public Tourist fetchTouristById(Integer id);
      	public List<Tourist> fetchAllTourists();
      	public String updateBudget(Integer id,Double budget);
      	public List<Tourist> getTouristWithRange(Double start , Double end);
      	public String deleteTourist(Integer id);
}
