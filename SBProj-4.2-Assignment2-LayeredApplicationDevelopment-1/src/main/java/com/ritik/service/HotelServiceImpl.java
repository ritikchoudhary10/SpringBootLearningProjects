package com.ritik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.bean.Hotel;
import com.ritik.dao.HotelDao;

@Service("svs")
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelDao dao;

	@Override
	public List<Hotel> gethotelDetails(String name1, String name2, String name3) throws Exception {
		
		return dao.getAllHotels(name1, name2, name3); 
		
	}

}
