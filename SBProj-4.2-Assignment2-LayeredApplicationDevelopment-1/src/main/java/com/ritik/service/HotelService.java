package com.ritik.service;

import java.util.List;

import com.ritik.bean.Hotel;

public interface HotelService {
	
	public List<Hotel> gethotelDetails(String name1 , String name2 , String name3) throws Exception;
}
