package com.ritik.dao;

import java.util.List;

import com.ritik.bean.Hotel;

public interface HotelDao {

	public List<Hotel> getAllHotels(String state1 , String state2 , String state3) throws Exception;
} 
